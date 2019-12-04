public class Timer {
    private long startTime = 0;
    private long endTime = 0;
    private int durationTime= 0;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long countDurationTime(){
        return endTime - startTime;
    }
}
