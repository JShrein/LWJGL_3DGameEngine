package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) 
	{
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
		
		float[] vertices = {
				-0.5f, 0.5f, 0.0f,	//v0
				-0.5f, -0.5f, 0.0f,	//v1
				0.5f, -0.5f, 0.0f,	//v2
				0.5f, 0.5f, 0.0f, 	//v3
		};
		
		int[] indices = {
				0, 1, 3,
				3, 1, 2
		};
		
		float[] texCoords = {
				0.0f, 0.0f,
				0.0f, 1.0f,
				1.0f, 1.0f,
				1.0f, 0.0f
		};
		
		
		RawModel model = loader.loadToVAO(vertices, texCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("Untitled"));
		TexturedModel texturedModel = new TexturedModel(model, texture);

		while(!Display.isCloseRequested())
		{
			renderer.prepare();
			
			shader.start();
			
			renderer.render(texturedModel);
			
			shader.stop();
			
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
