package shaders;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/basic.vert";
	private static final String FRAGMENT_FILE = "src/shaders/basic.frag";
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		// TODO Auto-generated method stub
		
	}

}
