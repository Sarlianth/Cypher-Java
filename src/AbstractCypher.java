
public abstract class AbstractCypher implements Cypherator  {
	
	private CypherKey key;

	public AbstractCypher() {
		super();
	}

	public String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}

	public byte[] encrypt(byte[] plainText) throws CypherException {
		return doCypher(plainText, true);
	}

	public String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		return doCypher(cypherText, false);
	}
	
	public CypherKey getCypherKey() {
		return key;
	}

	public void setCypherKey(CypherKey key) {
		this.key = key;
	}

	protected abstract byte[] doCypher(byte[] bytes, boolean encrypt) throws CypherException;

}