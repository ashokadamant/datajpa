package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="AM_PERSON_DETAILS")
@Getter
@Setter
public class Person implements Serializable{
@Id
//allocationsize is increment from initial value and sequence name is name of
//sequence(with what name you want to create the sequence) and name is logical name to
//get the link between the sequencegenerator and generatedvalue
//GenerationType.Sequence  details are mentioned in gen1 and gen1 is having all the
//details in the sequencegenerator.
//Note:Hibernate uses sequence generator  to generate the id value but all 
//those details(where to start,incremtn) are kept in gen1 generator
//in sequencegenerator anotation
@SequenceGenerator(name="gen1",initialValue=1000,allocationSize=1,sequenceName="PID_SEQ1")
@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)

 private Integer  pid;
private String pname;
private String paddrs;
/*//In many to many collection type properties are required and in one to many
also collection type properties required.how to tell i am looking for one to many 
not many to many?we have to use onetomany annotation.
one to many  has to hold phoneNumber.class entity.
if any persistence operations happened/takes place on parent object,if you want to carry that 
persistent operation to associated child object,for this we use cascade option and we have to 
take cascade=CascadeType.ALL
Note:if you call save method on parent object not only parent object should be save
associated child objects records also should be saved in child table.
if you perform update operation on parent object then associated child records in the
 db table.
Note:cascade will cascade non select persistence operations
Note:if you are performing select operations on the table,if you would like to load the 
child table records very lazily then you should use Fetch=fetchType.LAZY
fetch is related to loading of records.Loading parent objects normally but associated 
child objects will be loaded lazily.
parent object should select its right child object based on the FK column

if cascade is not used,only on parent table only persistence operations takes place.persistence 
opreations not takes place on child table.

*/
@OneToMany(targetEntity=PhoneNumber.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="PERSON_ID",referencedColumnName="PID")
private Set<PhoneNumber> phoneNumbers;
 
public Person() {
	System.out.println("Person-0 param constructor.");
}

@Override
public String toString() {
	return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
}



}
