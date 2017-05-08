package g_3_2_9

class Child {

	String dummy

	static belongsTo = [ parent : Parent ]

    static constraints = {
		parent nullable: false
    }
}
