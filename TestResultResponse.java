package com.company;

public class TestResultResponse {

    public void TestResultResponse(int testResult) {                                         /** The test result value from test lab.*/
        int x = testResult;
        switch (x) {
            case 0:
                System.out.println("The test result does not exist yet");                    /** The test result value from test lab.*/
                break;
            case 1:
                System.out.println("No indication for COVID-19");                            /**  No indication for COVID-19.*/
                break;
            case 2:
                System.out.println("The test result indicates infection with COVID-19");     /** The test result indicates infection with COVID-19.*/
                break;
            case 3:
                System.out.println(" The test result is invalid due to unknown reason");     /** TThe test result is invalid due to unknown reason.*/
                break;
            case 4:
                System.out.println(" The test result is redeemed by time");                  /** The test result is redeemed by time.*/
                break;
            default:
                System.out.println("Wrong input please try again");                          /** Wrong input.*/
        }
    }

}