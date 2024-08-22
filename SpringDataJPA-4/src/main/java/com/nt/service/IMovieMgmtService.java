package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repo.PersonRepo;
import com.nt.repo.PhoneNumberRepo;

@Service
public class IMovieMgmtService {
  @Autowired
  private PersonRepo prepo;
  @Autowired
  private PhoneNumberRepo nrepo;
  
	/* public String removeMovieByIds(List<Integer> ids) {
	 List<Movie>list= movierepo.findAllById(ids);
	 int count=list.size();
	 movierepo.deleteAllByIdInBatch(ids);//since the return type is void we cannot know the how many records are deleted
	 //for this purpose we use findAllById(ids) to know  how many records are present out of the given ids in the db and then we pass deleteallByInBatch to delete all theids.
	 
	 return count+" no of records are deleted";
	 }*/
  public String saveDataUsingParent(Person person) {
	 return  prepo.save(person).getPid()+" person data is saved";
  }
  public void loadDataUsingParent() {
	 List<Person> parents = prepo.findAll();
	 /* parents.forEach(per->{
	                 System.out.println("parent "+per);
	                 //getChilds of each parent
			Set<PhoneNumber> childs=per.getPhoneNumbers();
			 childs.forEach(child->{
			  System.out.println("child "+child);
			 });
			                        
	                 });*/
  }
  public String deleteParentAndItsChild(int pid) {
	 Optional<Person> opt = prepo.findById(pid);
	 //here along with parent object,the associated child objects will be loaded
	 if(opt.isPresent()) {
		 prepo.delete(opt.get());
		 return "person and his phone numbers are deleted";
	 }
	 else {
		 return "person not found";
	 }
	 
  }
 public String deleteAllPhoneNumbersOfaPerson(Integer pid) {
	Optional<Person> opt = prepo.findById(pid);
	if(opt.isPresent()) {
		Set<PhoneNumber> childs=opt.get().getPhoneNumbers();
		nrepo.deleteAll(childs);
		return "all childs are deleted ";
	}
	return "person not found";
 }
  
 }
