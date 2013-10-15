package dogBeans;

import monitor.DataDogCalls;

public class DataDogRecording implements DataDogRecordingMBean {
    private DataDogCalls dataDogCalls;

    public DataDogRecording(DataDogCalls dataDogCalls) {
        System.out.println("YAY! I'm ALIVE!!");
        this.dataDogCalls = dataDogCalls;
    }

    @Override
    public void logSuccess() {
        dataDogCalls.logSuccess();
    }
}
