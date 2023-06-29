package ashwin.railwayticket;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    boolean loop=true;
    while(loop){

    
    System.out.println("1. BookTicket \n2. CancelTicket \n3. Available Tickets \n4. BookedTickets\n 5. Exit");
    int choice=sc.nextInt();
    switch(choice){
      case 1: 
              System.out.println(" Enter Name : ");
              String name=sc.next();
              System.out.println(" Enter age : ");
              int age=sc.nextInt();
             System.out.println(" Enter Berth Preference : ");
             String berthprefernece=sc.next();
             Passenger p=new Passenger(name, age, berthprefernece);
             bookticket(p);
             break;
          
      
      case 2:
            System.out.println(" Enter the id to cancel");
            TicketBooker booker=new TicketBooker();
            int id=sc.nextInt();
            if(!booker.passengers.containsKey(id)){
              System.out.println("no passengers detail availble;");
            }else{
                booker.cancelticket(id);
            }
             break;
      case 3:
            TicketBooker booker1=new TicketBooker();
            booker1.printavailableberths();
            break;
      case 4:
            TicketBooker booker2=new TicketBooker();
            booker2.printallpassengers();
            break;
      case 5:
            loop=false;



    }
  }
  }

  static void bookticket(Passenger p) {
      TicketBooker booker=new TicketBooker();
      if(booker.availablewaitinglist==0){
        System.out.println("No tickets availabale");
      }
      if(p.berthprefrence.equals("L")&& TicketBooker.availabaleLowerberths > 0 ||
      p.berthprefrence.equals("M")&& TicketBooker.availabaleMiddleberths > 0 ||
      p.berthprefrence.equals("U")&& TicketBooker.availabaleUpperberths > 0 ){
        if(p.berthprefrence.equals("L")){
          System.out.println("Lower berth given");
          booker.bookticket(p, (TicketBooker.lowerberthpositions.get(0)), "L");
          TicketBooker.lowerberthpositions.remove(0);
          TicketBooker.availabaleLowerberths--;
        }else if(p.berthprefrence.equals("U")){
          System.out.println("Upper berth given");
          booker.bookticket(p, (TicketBooker.upperberthpositions.get(0)), "U");
          TicketBooker.upperberthpositions.remove(0);
          TicketBooker.availabaleUpperberths--;
        }else if(p.berthprefrence.equals("M")){
          System.out.println("Middle berth given");
          booker.bookticket(p, (TicketBooker.middleberthpositions.get(0)), "M");
          TicketBooker.middleberthpositions.remove(0);
          TicketBooker.availabaleMiddleberths--;
        }

      }else if(TicketBooker.availabaleLowerberths>0){
          System.out.println("Lower berth given");
          booker.bookticket(p, (TicketBooker.lowerberthpositions.get(0)), "L");
          TicketBooker.lowerberthpositions.remove(0);
          TicketBooker.availabaleLowerberths--;
        }else if(TicketBooker.availabaleUpperberths>0){
          System.out.println("Upper berth given");
          booker.bookticket(p, (TicketBooker.upperberthpositions.get(0)), "U");
          TicketBooker.upperberthpositions.remove(0);
          TicketBooker.availabaleUpperberths--;
        }else if(TicketBooker.availabaleMiddleberths>0){
          System.out.println("Middle berth given");
          booker.bookticket(p, (TicketBooker.middleberthpositions.get(0)), "M");
          TicketBooker.middleberthpositions.remove(0);
          TicketBooker.availabaleMiddleberths--;
        }else if(TicketBooker.availabaleRactickes>0){
          System.out.println("RAC ticket given");
             booker.addtorac(p, (TicketBooker.racpositions.get(0)), "RAC");
          TicketBooker.racpositions.remove(0);
          TicketBooker.availabaleRactickes--;
        }else if(TicketBooker.availablewaitinglist>0){
          booker.addtowaitingList(p, (TicketBooker.waitinglistpositions.get(0)), "wl");
          TicketBooker.waitinglistpositions.remove(0);
          TicketBooker.availablewaitinglist--;
        }


  }

  
}
