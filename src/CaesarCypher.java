
public class CaesarCypher extends AbstractCypher{
	
	public CaesarCypher(CypherKey key) {
		super();
		super.setCypherKey(key);
	}
	
	public CaesarCypher(int key) {
		super();
		CypherKey ck = new CypherKeyImpl();
		ck.setKey(key + "");
		super.setCypherKey(ck);
	}

	protected byte[] doCypher(byte[] bytes, boolean encrypt) throws CypherException {
		
		byte[] temp = new byte[bytes.length];
		
		for(int i=0; i<bytes.length; i++){
			
			if(encrypt){
				temp[i] = (byte)(bytes[i] + Integer.parseInt(super.getCypherKey().getKey()));
			}else{
				temp[i] = (byte)(bytes[i] - Integer.parseInt(super.getCypherKey().getKey()));
			}
		}
		
		return temp;
	}

	// Destructor - called when an object goes out of scope and before it gets GC'd
	protected void finalize() throws Throwable {
		super.finalize();
	}



	
	private class CypherKeyImpl implements CypherKey{
		
		private int key;

		public String getKey() {
			return new String(String.valueOf(key));
		}

		public void setKey(String key) {
			this.key = Integer.parseInt(key);
		}
		
	}

}
