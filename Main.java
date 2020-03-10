import java.util.*;
import java.time.*;
import java.text.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] aLarms = new int[5][3];
    String[][] ameridian = new String[5][1];
    char co = ':';
    String be = "*beep*";
    String y = "yes";
    String ye = "Yes";
    boolean running = true;
    int aSet = 0;
    System.out.printf("Do you want to set a Alarm? %n");
    ZoneId tZ1 = ZoneId.of("America/Chicago");
    int aHour = 0;
    int aMinute = 0;
    int aSecond = 0;
    int numa = 1;
    String aMeridian = "N/A";
    String q1 = sc.nextLine();
    if(q1.equals(y) || q1.equals(ye)){
    System.out.printf("How many alarms do you want to set?%n");
    numa = sc.nextInt();
    aLarms = new int[numa][3];
    ameridian = new String[numa][1];
    }
    for(int i = 0; i < numa; i++){
    System.out.printf("Please Set the Alarm's hour, minute, second and Meridian%n");
    aHour = sc.nextInt();
    aLarms[i][0] = aHour;
    aMinute = sc.nextInt();
    aLarms[i][1] = aMinute;
    aSecond = sc.nextInt();
    aLarms[i][2] = aSecond;
    aMeridian = sc.next();
    if(aMeridian.equals("pm")){
      aMeridian = "PM";
    }
    else if(aMeridian.equals("am")){
      aMeridian = "AM";
    }
    ameridian[i][0] = aMeridian;
    aSet++;
    }
    while(running){
    LocalTime clock = LocalTime.now(tZ1);
    int hour = clock.getHour();
    int minute = clock.getMinute();
    int second = clock.getSecond();
    String meridian;
    if(hour < 12){
      meridian = "AM";
    }
    else{
      meridian = "PM";      
    }

    hour %= 12;
    
    String time = hour + minute + second + meridian;

    if(hour == 0){
      System.out.printf("%d%c%02d%c%02d %s%n", 12, co, minute, co, second, meridian);
    }

    else{
      System.out.printf("%02d%c%02d%c%02d %s%n", hour, co, minute, co, second, meridian);
    }
    if(aSet >= 1){
    for(int o = 0; o < numa; o++){
    if(hour == aLarms[o][0] && minute == aLarms[o][1] && second == aLarms[o][2] && meridian.equals(ameridian[o][0])){
      System.out.printf("%s%n%s%n%s%n", be, be, be);
    }
    }
    }
    try{
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {
      System.err.format("IOException: %s%n", e);
    }
    }
    }
}
