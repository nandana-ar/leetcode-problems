//-----------------------------PROBLEM 401--------------------------------//
//                            BINARY WATCH                                //


// Logic:
// -> Initialize an empty list ans to store the valid time strings
// -> Loop through all possible hours (0 to 11):
//    - Loop through all possible minutes (0 to 59):
//       - Calculate the total number of bits that are on in the current hour 
//         and current minute
//       - If the total number of bits on equals turnedOn, then we have a 
//         valid time:
//          - Convert the hour to a string (hourString)
//          - Convert the minute to a string (minuteString), ensuring it is
//            two digits by adding a leading zero if necessary
//          - Build the final time string in the format "hour:minute" and add it
//            to the ans list
// -> After looping through all hours and minutes, return the ans list containing
//    all valid time strings


class Solution {
    public List<String> readBinaryWatch(int turnedOn) {

        List<String> ans = new ArrayList<String>();

        for (int hour = 0; hour < 12; ++hour) {
            for (int minute = 0; minute < 60; ++minute) {

                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (totalBits == turnedOn) {
                    String hourString = String.valueOf(hour);

                    String minuteString;

                    if (minute < 10) {
                        minuteString = "0" + minute;
                    } else {
                        minuteString = String.valueOf(minute);
                    }

                    String timeString = hourString + ":" + minuteString;

                    ans.add(timeString);
                    
                }
            }
        }
        return ans;
    }
}


// Time Complexity:
// -> Loop through 12 hours and 60 minutes: O(12 * 60) = O(720) 
// => O(1)
// since the number of hours and minutes is fixed
