
public class CypherRunner {

	public static void main(String[] args) throws Throwable{
		Cypherator cc = new CaesarCypher(99999);
	
		
		String message = "Hello";
		System.out.println(cc.encrypt(message));
		System.out.println(cc.decrypt(cc.encrypt(message)));

	}

}
