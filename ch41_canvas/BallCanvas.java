package ch41_canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Random;

public class BallCanvas extends Canvas implements Runnable, ComponentListener {
//Canvas : �׷��� ó���� ���� ������Ʈ
//Runnable : ��Ƽ������ ������ ���� �������̽�
//ComponentListener : ȭ������� ������ �����ϱ� ���� �������̽�

	private int x, y;
	private int moveX = 2, moveY = 3;
	private int red, green, blue;
	private Random random;
	private int width, height;
	// ������۸� ó���� ���� ���� �߰�
	// ��׶��� �̹��� ����(��ȭ�� ����)
	private Image offImage;
	// ��׶��� �̹����� �׷��� ����� ���� ��ü (�� ����)
	private Graphics bg;
	

	public BallCanvas() {
		// ȭ�� ���� ������ �����ϱ� ���� ������ �߰�
		addComponentListener(this);
		// ���� ���� ó���� ���� ���� ��ü ����
		random = new Random();
		// ��ǥ�� ������ ���� ��׶��� ������ ����
		Thread thread = new Thread(this);
		// ��׶��� ������ ���� ��û
		thread.start(); // run()�� ȣ���
	}

	// �׷��� ó�� �ڵ�
	public void paint(Graphics g) {
		// ������
		g.setColor(new Color(red, green, blue));
		// Ÿ���׸��� fillOval(x,y, width, height)
		g.fillOval(x, y, 20, 20);
	}

	void setColor() {
		red = random.nextInt(256); // 0~255
		green = random.nextInt(256);
		blue = random.nextInt(256);
	}

	@Override
	public void run() {
		while (true) {// ���ѹݺ�
			if (x > (width - 20) || x < 0) {// �¿� ��ó��
				moveX = -moveX; // ����, ���� ���� ����
				setColor();
			}
			if (y > (height - 20) || y < 0) {// ���� ��ó��
				moveY = -moveY;
				setColor();
			}
			x += moveX; // x��ǥ�� ����
			y += moveY; // y��ǥ�� ����
			repaint(); // �׷��� ���� ��û => paint()�� �����
			try {
				Thread.sleep(30); // ��ø���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentResized(ComponentEvent e) {
		// ���� �������� ȭ���� ����, ���� ���� ���

		width = getWidth();
		height = getHeight();

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

}
