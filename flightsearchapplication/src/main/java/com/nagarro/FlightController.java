package com.nagarro;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 * Created by Ritik on 24/03/21.
 */
public class FlightController {
    ArrayList<FlightModel> flightList=new ArrayList<FlightModel>();
    ArrayList<String> arr;
    FlightView view=new FlightView();

    public void searchFlight(ArrayList<String> CSV_data,String dept_loc,String arrival_loc,String date) throws FileNotFoundException, ParseException
    {
//    	for(int line=0;line<CSV_data.size();line++)
//    	{
//    		String line_content=CSV_data.get(line);
//    		if (!line_content.isEmpty()) {
//                StringTokenizer token = new StringTokenizer(line_content, "|");
//                arr = new ArrayList(line_content.length());
//                while (token.hasMoreTokens()) {
//                    arr.add(token.nextToken());
//                }
//                Date requested_date=new SimpleDateFormat("dd/MM/yyyy").parse(date);
//                Date Valid_Till=new SimpleDateFormat("dd-MM-yyyy").parse(arr.get(3));
//                
//                if (arr.get(1).equals(dept_loc) && arr.get(2).equals(arrival_loc) &&  (Valid_Till.compareTo(requested_date)>=0)) {
//                    FlightModel model = new FlightModel(arr.get(0), arr.get(1), arr.get(2), arr.get(3), Integer.parseInt(arr.get(4)), Float.parseFloat(arr.get(5)));
//                    flightList.add(model);
//                  
//                }
//            }
//    	}
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   	    Session session = sessionFactory.openSession();
   	    Transaction tnx=session.beginTransaction();

   	    Query q=session.createQuery("from CSVData ");
   	    List<CSVData> lst=q.list();
   	    List<CSVData> res=new ArrayList<CSVData>();
   	    for(CSVData l:lst)
   	    {
   	    	
   	    	Date requested_date=new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Date Valid_Till=new SimpleDateFormat("dd-MM-yyyy").parse(l.valid_till);
   	    	
   	    	if (l.dep_loc.equals(dept_loc) && l.arr_loc.equals(arrival_loc) &&  (Valid_Till.compareTo(requested_date)>=0) && (l.seat_av.equals("Y")) ) 
   	    	{
                FlightModel model = new FlightModel(l.flight_no, l.dep_loc, l.arr_loc, l.valid_till, l.fare, (float)l.getFlight_dur());
                flightList.add(model);	
//  	    	System.out.println(l.getFlight_no()+" : "+l.getArr_loc()+" : "+l.dep_loc+" : "+l.valid_till+" : "+l.flight_time+" : "+l.flight_dur+" : "+l.fare+" : "+l.seat_av+" : "+l.class_av);
   	    	}
   	    }
   	    tnx.commit();
    }

    public void updateView(int choiceCode)
    {
        if(choiceCode==1)
        {
            Collections.sort(flightList, new Comparator<FlightModel>() {
                public int compare(FlightModel o1, FlightModel o2) {
                    return o1.getFare() - o2.getFare();
                }
            });
        }
        else if(choiceCode==2)
        {
            Collections.sort(flightList, new Comparator<FlightModel>() {
                public int compare(FlightModel o1, FlightModel o2) {
                	int a=((o1.getDuration() - o2.getDuration())>0)?1:((o1.getDuration() - o2.getDuration())<0)?-1:0;
                    return a;
                }
            });
        }
        else
        {
            System.out.println("Wrong Choice.");
            return;
        }
        view.viewFlights(flightList);

    }
}
