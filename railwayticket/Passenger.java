package ashwin.railwayticket;

public class Passenger {
   String name;
  int age;
  String berthprefrence;
   static int id=1;
   int seatnumber=0;
   int passengerId=0;
    String alloted;
    public Passenger(String name,int age,String berthprefrence){
      this.name=name;
      this .age=age;
      this.berthprefrence=berthprefrence;
      alloted=" ";
      seatnumber=-1;
      passengerId=id++;

    }

  
}
