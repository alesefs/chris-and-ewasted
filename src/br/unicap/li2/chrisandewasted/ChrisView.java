package br.unicap.li2.chrisandewasted;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ChrisView extends View implements Runnable {

	public ChrisActivity activity;

	private Context context;
	
	Paint paint = new Paint();
	Paint textview = new Paint();

	Bitmap chris1, chris2, chris3, chris4, chris5;
	Bitmap cenario1, cenario2, cenario3, cenario4, cenario5;
	Bitmap inimigo1, inimigo2, inimigo3, inimigo4, inimigo5;
	Bitmap vilao1, vilao2, vilao3, vilao4, vilao5;
	Bitmap pc, celular, camera;
	
	
	int vtempo;
	int velocidade = 3;
	int hud_vida_i = 20;
	int hud_pontos_i;
	int posicaobg1 = 480;
	int posicaobg2, posicaobg3, posicaobg4, posicaobg5 = -480;
	int inimigoX, vilaoX, pcX, celularX, cameraX;
	int inimigoY, vilaoY, pcY, celularY, cameraY = 100;

	private static float chrisY;
	private static float chrisTouchY;
	int chrisX = 0;
	
	MediaPlayer fundo_bg;

	String FPS, hud_vida, hud_pontos, game_over, venceu;

	private static final int INTERVAL = 20;
	private boolean running = true;

	public ChrisView(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub

		// Chris
		chris1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_000);
		chris2 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_001);
		chris3 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_002);
		chris4 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_003);
		chris5 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_004);

		// inimigo
		inimigo1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_100);
		inimigo2 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_101);
		inimigo3 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_102);
		inimigo4 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_103);
		inimigo5 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_104);

		// vilao
		vilao1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_200);
		vilao2 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_201);
		vilao3 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_202);
		vilao4 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_203);
		vilao5 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.animation_sheet_204);

		// cenario
		cenario1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.cenariochris_001);
		cenario2 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.cenariochris_002);
		cenario3 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.cenariochris_003);
		cenario4 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.cenariochris_004);
		cenario5 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.cenariochris_005);

		// reciclaveis
		pc = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.note_pc);
		celular = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.phone_old);
		camera = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.photo_cam);

		paint = new Paint();
		Thread minhathread = new Thread(this);
		minhathread.setPriority(Thread.MIN_PRIORITY);
		minhathread.start();

    	

    	fundo_bg = MediaPlayer.create(getContext(), R.raw.fundo);
    	fundo_bg.start();
    	fundo_bg.setLooping(true);
    	Log.i("init","loop");
    	
    	    	
	}
	
	
	// metodo run - runnable
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				Log.e("game", "crhis and e-waste");
			}
			update();

		}

	}

	// atualização da runnable
	private void update() {
		// TODO Auto-generated method stub
		postInvalidate();

	}

	public void release() {
		running = false;
	}

	// pintando objetos na tela
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		super.onDraw(canvas);

		
		vtempo++;

		inimigoY = canvas.getHeight() / 2 - 55;
		vilaoY = canvas.getHeight() / 2 - 5;

		// cenario
		canvas.drawBitmap(cenario5, 100, 0, paint);
		canvas.drawBitmap(cenario1, posicaobg1, 0, paint);
		canvas.drawBitmap(cenario2, posicaobg2, 0, paint);
		canvas.drawBitmap(cenario3, posicaobg3, 0, paint);
		canvas.drawBitmap(cenario4, posicaobg4, 0, paint);
		canvas.drawBitmap(cenario5, posicaobg5, 0, paint);
		cenario(canvas);
		

		
		// animacao de chris
		if (vtempo >= 0 && vtempo <= 20) {
			canvas.drawBitmap(chris1, chrisX + 20, chrisY, paint);
		}

		if (vtempo > 20 && vtempo <= 40) {
			canvas.drawBitmap(chris2, chrisX + 20, chrisY, paint);
		}

		if (vtempo > 40 && vtempo <= 60) {
			canvas.drawBitmap(chris3, chrisX + 20, chrisY, paint);
		}

		if (vtempo > 60 && vtempo <= 80) {
			canvas.drawBitmap(chris4, chrisX + 20, chrisY, paint);
		}

		if (vtempo > 80 && vtempo <= 100) {
			canvas.drawBitmap(chris5, chrisX + 20, chrisY, paint);
		}

		if (vtempo > 100 || vtempo < 0) {
			vtempo = 0;
		}

		// animação inimigo1
		if (vtempo >= 0 && vtempo <= 20) {
			canvas.drawBitmap(inimigo1, inimigoX + velocidade + 20,
					inimigoY + 10, paint);
		}

		if (vtempo > 20 && vtempo <= 40) {
			canvas.drawBitmap(inimigo2, inimigoX + velocidade + 20,
					inimigoY + 10, paint);
		}

		if (vtempo > 40 && vtempo <= 60) {
			canvas.drawBitmap(inimigo3, inimigoX + velocidade + 20,
					inimigoY + 10, paint);
		}

		if (vtempo > 60 && vtempo <= 80) {
			canvas.drawBitmap(inimigo4, inimigoX + velocidade + 20,
					inimigoY + 10, paint);
		}

		if (vtempo > 80 && vtempo <= 100) {
			canvas.drawBitmap(inimigo5, inimigoX + velocidade + 20,
					inimigoY + 10, paint);
		}

		if (vtempo > 100 || vtempo < 0) {
			vtempo = 0;
		}

		// chamada metodo para inimigo o de cima na tela
		inimigo(canvas);

		// animação inimigo1
		if (vtempo >= 0 && vtempo <= 20) {
			canvas.drawBitmap(vilao1, vilaoX + velocidade + 20, vilaoY + 10,
					paint);
		}

		if (vtempo > 20 && vtempo <= 40) {
			canvas.drawBitmap(vilao2, vilaoX + velocidade + 20, vilaoY + 10,
					paint);
		}

		if (vtempo > 40 && vtempo <= 60) {
			canvas.drawBitmap(vilao3, vilaoX + velocidade + 20, vilaoY + 10,
					paint);
		}

		if (vtempo > 60 && vtempo <= 80) {
			canvas.drawBitmap(vilao4, vilaoX + velocidade + 20, vilaoY + 10,
					paint);
		}

		if (vtempo > 80 && vtempo <= 100) {
			canvas.drawBitmap(vilao5, vilaoX + velocidade + 20, vilaoY + 10,
					paint);
		}

		if (vtempo > 100 || vtempo < 0) {
			vtempo = 0;

		}

		// chamada de metodo vilao
		vilao(canvas);

		// reciclaveis
		canvas.drawBitmap(pc, pcX, pcY + 140, paint);
		canvas.drawBitmap(celular, celularX, celularY + 65, paint);
		canvas.drawBitmap(camera, cameraX, cameraY - 1, paint);

		reciclaveis(canvas);

		// chamada de metodo para o textview marcador
		marcador(canvas);
		
	}

	// touch movimento Y na screen landscape
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (chrisY <= 1 || chrisY >= 0) {
			final int action = event.getAction();

			switch (action) {
			case MotionEvent.ACTION_DOWN: {
				final float y = event.getY();

				chrisTouchY = y;
				break;
			}

			// mudar para case pulo, rastejo
			case MotionEvent.ACTION_MOVE: {
				final float y = event.getY();

				// calcula a distancia do movimento
				final float dy = y - chrisTouchY;

				// move o objeto
				chrisY += dy;

				if (chrisY >= getHeight() - 65) {
					chrisY = getHeight() - 66;
				}

				if (chrisY <= getHeight() / 5 + 20) {
					chrisY = getHeight() / 5 + 19;
				}

				
				/*if (chrisY >= getHeight() - 108) {
					chrisY = getHeight() - 107;
				}

				if (chrisY <= getHeight() - 180) {
					chrisY = getHeight() - 181;
				}*/

				// Lembra a posição do toque para o proximo movimento
				chrisTouchY = y;

				invalidate();
				break;

			}
			}
		}
		// fim touch event

		return true;
	}
	
	// metodo marcador
		private void marcador(Canvas marcador) {
			// TODO Auto-generated method stub
			textview.setARGB(0, 0, 0, 0);

			FPS = "FPS: " + vtempo;
			hud_vida = "VIDA: " + hud_vida_i + " /20";
			hud_pontos = "PONTOS: " + hud_pontos_i + " /1200";

			marcador.drawText(FPS, 10, 200, paint);
			marcador.drawText(hud_vida, 10, 25, paint);
			marcador.drawText(hud_pontos, 10, 40, paint);

		}

		// metodo cenario + movimento cenario
			private void cenario(Canvas canvas) {
				// TODO Auto-generated method stub
				posicaobg1 -= velocidade;
				posicaobg2 -= velocidade;
				posicaobg3 -= velocidade;
				posicaobg4 -= velocidade;
				posicaobg5 -= velocidade;

				if (posicaobg1 < -this.getWidth()) {
					posicaobg1 = posicaobg5 + cenario1.getWidth();
				}
				if (posicaobg2 < -this.getWidth()) {
					posicaobg2 = posicaobg1 + cenario2.getWidth();
				}
				if (posicaobg3 < -this.getWidth()) {
					posicaobg3 = posicaobg2 + cenario3.getWidth();
				}
				if (posicaobg4 < -this.getWidth()) {
					posicaobg4 = posicaobg3 + cenario4.getWidth();
				}
				if (posicaobg5 < -this.getWidth()) {
					posicaobg5 = posicaobg4 + cenario5.getWidth();
				}

				this.invalidate();
			}
	
	
	// metodo de criação do inimigo
	private void inimigo(Canvas canvas) {
		// TODO Auto-generated method stub

		inimigoX -= velocidade * 1.25;

		if (inimigoX < -this.getWidth()) {
			inimigoX = this.getWidth() * 2 - inimigoX
					+ (int) Math.ceil(Math.random() * 2);
		}

		if (inimigoX >= this.getWidth()) {
			inimigoX -= velocidade;
		}

		// colisão inimigo
		if (inimigoX <= chrisX + 15 && chrisY >= inimigoY - 10
				&& chrisY <= inimigoY + 28 && inimigoX >= chrisX - 15) {
			inimigoX = this.getWidth() * 2 + inimigoX
					+ (int) Math.ceil(Math.random() * 2);
			;

			inimigoX -= velocidade;
			hud_vida_i -= 1;
			
	    	MediaPlayer hit = MediaPlayer.create(getContext(), R.raw.hit);
			hit.start();
		}
	}

	
	
	// metodo de criação vilao
	private void vilao(Canvas canvas) {
		// TODO Auto-generated method stub

		vilaoX -= velocidade * 1.25;

		if (vilaoX < -this.getWidth()) {
			vilaoX = this.getWidth() * 2 - vilaoX - vilaoX
					- (int) Math.ceil(Math.random() * 2);
			;
		}

		if (vilaoX >= this.getWidth()) {
			vilaoX -= velocidade;
		}

		// colisão vilao
		if (vilaoX <= chrisX + 15 && chrisY >= vilaoY - 20
				&& chrisY <= vilaoY + 25 && vilaoX >= chrisX - 15) {
			vilaoX = this.getWidth() * 2 + vilaoX
					+ (int) Math.ceil(Math.random() * 2);
			;

			vilaoX -= velocidade;
			hud_vida_i -= 1;
			
			MediaPlayer hit = MediaPlayer.create(getContext(), R.raw.hit);
			hit.start();
		}
		
		
		this.invalidate();
		
	}

	
	
	private void reciclaveis(Canvas canvas) {
		// TODO Auto-generated method stub
		pcX -= velocidade;
		celularX -= velocidade;
		cameraX -= velocidade;

		if (pcX < -this.getWidth() * 2) {
			pcX = this.getWidth() * 2 + 125;
		}

		if (celularX < -this.getWidth() * 2) {
			celularX = this.getWidth() * 2 + 1500;
		}

		if (cameraX < -this.getWidth() * 2) {
			cameraX = this.getWidth() * 2 + 2200;
		}

		this.invalidate();

		// colisão reciclaveis -- os valores numericos sao referencias as
		// posiçoes iniciais dos objetos

		// colisao pc
		if (pcX <= chrisX + 10 && pcX >= chrisX - 10 && pcY <= chrisY - 130
				&& pcY >= chrisY - 150) {
			pcX = this.getWidth() * 2 + pcX * 5
					+ (int) Math.ceil(Math.random() * 2);
			;
			pcX -= velocidade;

			hud_pontos_i += 10;
			
	    	MediaPlayer premio = MediaPlayer.create(getContext(), R.raw.premio);
	    	premio.start();
		}

		// colisao celular
		if (celularX >= chrisX - 10 && celularX <= chrisX + 10
				&& celularY >= chrisY - 80 && celularY <= chrisY - 50) {
			celularX = this.getWidth() * 2 + celularX * 2
					+ (int) Math.ceil(Math.random() * 2);
			;
			celularX -= velocidade;
			hud_pontos_i += 20;
			
			MediaPlayer premio = MediaPlayer.create(getContext(), R.raw.premio);
	    	premio.start();
		}

		// colisao camera
		if (cameraX >= chrisX - 15 && cameraX <= chrisX + 15
				&& chrisY >= cameraY - 15 && chrisY <= cameraY + 15) {
			cameraX = this.getWidth() * 2 + cameraX
					+ (int) Math.ceil(Math.random() * 2);
			;
			cameraX -= velocidade;
			hud_pontos_i += 30;
			
			MediaPlayer premio = MediaPlayer.create(getContext(), R.raw.premio);
	    	premio.start();
		}
		
			this.invalidate();
		
		//VIDA
		if(hud_vida_i <= 0){
			
			canvas.drawColor(Color.WHITE);
			Paint paint = new Paint();
			canvas.drawRect(100, 100, 100, 100, paint);
			
			textview.setARGB(0, 0, 0, 0);
			game_over = "G A M E - O V E R";
			canvas.drawText(game_over, getHeight()/3, getWidth()/3, paint);
			
			fundo_bg.setLooping(false);
			fundo_bg.stop();
			
			chris1.eraseColor(INVISIBLE);
			chris2.eraseColor(INVISIBLE);
			chris3.eraseColor(INVISIBLE);
			chris4.eraseColor(INVISIBLE);
			chris5.eraseColor(INVISIBLE);
			
			GameOver();
		}
		
}	
/*		//PONTOS
		if(hud_pontos_i >= 1200){
			
			canvas.drawColor(Color.WHITE);
			Paint paint = new Paint();
			canvas.drawRect(100, 100, 100, 100, paint);
			
			textview.setARGB(0, 0, 0, 0);
			venceu = "P A R A B É N S";
			canvas.drawText(venceu, getHeight()/3, getWidth()/3, paint);
			
			fundo_bg.setLooping(false);
			fundo_bg.stop();
			
			chris1.eraseColor(INVISIBLE);
			chris2.eraseColor(INVISIBLE);
			chris3.eraseColor(INVISIBLE);
			chris4.eraseColor(INVISIBLE);
			chris5.eraseColor(INVISIBLE);
			
		}
	}
*/


	private void GameOver() {
		// TODO Auto-generated method stub

		((Activity) context).finish();
		Intent intent = new Intent(context, MainActivity.class);
		intent.putExtra("PONTOS", hud_pontos_i);
		context.startActivity(intent);
	}
}

