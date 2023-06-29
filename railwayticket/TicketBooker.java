package ashwin.railwayticket;

import java.util.*;

public class TicketBooker {
  static int availabaleLowerberths=1;
  static int availabaleUpperberths=1;
  static int availabaleMiddleberths=1;
  static int availabaleRactickes=1;
  static int availablewaitinglist=1;
  
  static Queue<Integer> qraclists=new LinkedList<>();
  static Queue<Integer> qwaitinglists=new LinkedList<>();
  static List<Integer> bookedticketlist=new ArrayList<>();

  static ArrayList<Integer> upperberthpositions=new ArrayList<>(Arrays.asList(1));
  static ArrayList<Integer> lowerberthpositions=new ArrayList<>(Arrays.asList(1));
  static ArrayList<Integer> middleberthpositions=new ArrayList<>(Arrays.asList(1));
  static ArrayList<Integer> racpositions=new ArrayList<>(Arrays.asList(1));
  static ArrayList<Integer> waitinglistpositions=new ArrayList<>(Arrays.asList(1));
  static Map<Integer,Passenger> passengers=new HashMap<>();
 public void bookticket(Passenger p,int berthinfo,String allotedseat){
  p.seatnumber=berthinfo;
  p.alloted=allotedseat;
  passengers.put(p.passengerId,p);
  bookedticketlist.add(p.passengerId);
  System.out.println("-----------------booked successfully---------------");
  

 }
 public void addtorac(Passenger p,int RACinfo,String allotedseat){
  p.seatnumber=RACinfo;
  p.alloted=allotedseat;
  passengers.put(p.passengerId, p);
  qraclists.add(p.passengerId);
    System.out.println("-----------------RAC ticketbooked successfully---------------");

 }public void addtowaitingList(Passenger p,int waitinfo,String allotedseat){
  p.seatnumber=waitinfo;
  p.alloted=allotedseat;
  passengers.put(p.passengerId, p);
  qraclists.add(p.passengerId);
    System.out.println("-----------------waiting list ticketbooked successfully---------------");

 }
public void cancelticket(int id){
  Passenger p=passengers.get(Integer.valueOf(id));
  int position=p.seatnumber;
  passengers.remove(Integer.valueOf(id));
  bookedticketlist.remove(Integer.valueOf(id));
  System.out.println("cancelled succesfully");
  if(p.alloted.equals("L")){
    availabaleLowerberths++;
    lowerberthpositions.add(position);

  }else if(p.alloted.equals("U")){
    availabaleUpperberths++;
    upperberthpositions.add(position);


  }else if(p.alloted.equals("M")){
    availabaleMiddleberths++;
    middleberthpositions.add(position);

  }

  if(qraclists.size()>0){
    Passenger passengerRac=passengers.get(qraclists.poll());
    int positionrac=passengerRac.seatnumber;
    racpositions.add(positionrac);
    qraclists.remove(Integer.valueOf(passengerRac.passengerId));
    availabaleRactickes++;
    if(qwaitinglists.size()>0){
      Passenger passengerwl=passengers.get(qwaitinglists.poll());
      int positionwl=passengerwl.seatnumber;
      waitinglistpositions.add(positionwl);
      qwaitinglists.remove(Integer.valueOf(passengerwl.passengerId));

      passengerwl.seatnumber=racpositions.get(0);
      passengerwl.alloted="RAC";
      racpositions.remove(0);
      qraclists.add(passengerwl.passengerId);
      availablewaitinglist++;
      availabaleRactickes--;



      
    }
    Main.bookticket(passengerRac);

  }
}
public void printavailableberths() {
  System.out.println(" the available births and positions ");
  System.out.println("availablelowerberths : "+availabaleLowerberths);
  System.out.println("availableupperberths : "+availabaleUpperberths);
  System.out.println("availablemiddleberths : "+availabaleMiddleberths);
  System.out.println("availableractickets : "+availabaleRactickes);
  System.out.println("availablewaitinglist : "+availablewaitinglist);
}
public void printallpassengers() {
    if(passengers.size()==0){
      System.out.println("no passengers available");
      return;
    }
    for(Passenger p: passengers.values()){
      System.out.println("passenger Id : "+ p.passengerId);
      System.out.println("passenger name : "+ p.name);
      System.out.println("passenger age : "+ p.age);
      System.out.print("passenger seatnumber & alloted : "+ p.seatnumber);
      System.out.println( p.alloted);

    }



}


}
