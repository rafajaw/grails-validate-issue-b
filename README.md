"# grails-validate-issue-b" 

This sample test project was created to show the inconsistency between Grails version 3.1.12 and 3.2.9, no other version was tested at this time to further identify when this behaviour began.

The inconsistency lies in the validate() method of a domain object when databinding with a one-to-one to a child object, where the child object has a belongsTo with a constraint of nullable:false.

Its easier to understand with an Example:


class Parent {
	Child child;
    static constraints = { }
}

class Child {
	String dummy;
	static belongsTo = [ parent : Parent ];
    static constraints = {
		parent( nullable: false )	// This is where validate() fails.
    }
}


So that if we use databinding like this (in this sample project, its in BootStrap.groovy):


def map = [
	"child": ["dummy": "populated"]
];
Parent parent  =  new Parent( map );


And then we call parent.validate() it will return FALSE for Grails 3.2.9 but will return TRUE for Grails 3.1.12.
In further investigation we can see that validate() method fails in Grails 3.2.9 because the constraint "parent( nullable: false )" wasn't met in the child object.

However, if we call parent.save() then the back-reference from child to parent gets populated properly and the validate() method begins to return TRUE even for Grails 3.2.9. Which is not always the use-case, in some use-cases we have to explicitly call validate on the object without saving it.
