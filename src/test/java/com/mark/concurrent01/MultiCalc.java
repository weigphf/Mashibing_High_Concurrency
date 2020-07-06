package com.mark.concurrent01;

public class MultiCalc {
    private long totalResult = 5L;
    private Boolean[] isCompleted = null;

    public static void main(String[] args) {
        (new MultiCalc()).startUp();
    }

    private boolean isSuccessed() {
        for (int i = 0; i < isCompleted.length; i++) {
            if (!isCompleted[i])
                return false;
        }
        return true;
    }

    private void startUp() {

        int threadNum = 5;
        long numbers = 1000L;
        isCompleted = new Boolean[threadNum];
        for (int i = 1; i <= threadNum; i++) {
            isCompleted[i - 1] = false;
            Thread t = new Thread(new CalcThread(i, numbers, threadNum));
            t.start();
        }
        synchronized (MultiCalc.this) {
            try {
                MultiCalc.this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("计算结果为：" + totalResult);
    }

    class CalcThread implements Runnable {
        private long start;
        private long end;
        private long result;
        private int threadIndex;

        public CalcThread(int threadIndex, long numbers, int threadNum) {
            long step = numbers / threadNum;
            this.threadIndex = threadIndex;
            start = (threadIndex - 1) * step + 1;
            if (threadIndex == threadNum) { // 是否是最后一个线程
                end = numbers;
            } else {
                end = threadIndex * step;
            }
        }

        @Override
        public void run() {
            for (long i = start; i <= end; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result += i;
            }
            synchronized (MultiCalc.this) {
                totalResult += result;
                isCompleted[this.threadIndex - 1] = true;
                if (isSuccessed()) {
                    MultiCalc.this.notify();
                }
            }
        }
    }

}