package g_3_2_9

import g_3_2_9.Parent;

class BootStrap {

	def grailsApplication

    def init = { servletContext ->
		def map = [
			"child": ["dummy": "populated"]
		];
		Parent parent  =  new Parent( map );
		
		println( "Grails version	-> ${grailsApplication.metadata.getGrailsVersion()}" );
		println( "" );
		println( "parent.child.parent -> " + parent.child.parent );
		println( "parent.validate() -> " + parent.validate() );
		parent.errors?.fieldErrors?.each { err ->
			println("error in field ${err.field} -> ${err.code}.");
		}
		println( "" );
		
		parent.save( );
		println( "NOW WE SAVE!" );
		
		println( "" );
		println( "parent.child.parent -> " + parent.child.parent );
		println( "parent.validate() -> " + parent.validate() );
		parent.errors?.fieldErrors?.each { err ->
			println("error in field ${err.field} -> ${err.code}.");
		}
		println( "" );
    }
    def destroy = {
    }
}
