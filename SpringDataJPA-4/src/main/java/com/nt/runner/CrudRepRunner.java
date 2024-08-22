package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMovieMgmtService;
@Component
public class CrudRepRunner implements CommandLineRunner{
  @Autowired
  private IMovieMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("----------deleteAllByIdInBatch(-)----------");
		try {
			//List<Integer> l=new ArrayList<>(Arrays.asList(25,null));
		//System.out.println(service.removeMovieByIds(List.of(12,25,null)));
			//here List.of cannot take null so we excepiton null pointer excepiotn
			//but in aslist method we can take null that ids can null .
		//System.out.println(service.removeMovieByIds(null));
		/*PhoneNumber ph1=new PhoneNumber();
		ph1.setPhoneNumber(70000685581l);
		ph1.setProvider("airtel");
		ph1.setNumberType("office");
		PhoneNumber ph2=new PhoneNumber();
		ph2.setPhoneNumber(832827329l);
		ph2.setNumberType("personal");
		ph2.setProvider("jio");
		Person per=new Person();
		per.setPname("venu");per.setPaddrs("bangaalore");
		per.setPhoneNumbers(Set.of(ph1,ph2));
		
		String msg=service.saveDataUsingParent(per);
		System.out.println(msg);
		
		*/
			//service.loadDataUsingParent();
			//service.deleteParentAndItsChild(1000);
		service.deleteAllPhoneNumbersOfaPerson(1001);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();

}
}
