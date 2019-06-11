package b;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class implements ISender{
	static String ADDRES
	static int PORT = 9090;
	static String PUBLIC_KEY_PATH="pubkp.txt";
	private byte[] msgBytes;
	
	public A16204103(byte[] msgBytes) {
		super();
		this.msgBytes = msgBytes;
	}
	public void send() {
		try {
			DatagramSocket dSocket = new DatagramSocket();
			byte[] bs = msgBytes;
			DatagramPacket dp = new DatagramPacket(bs, bs.length , InetAddress.getByName(ADDRESS),PORT);
			dSocket.send(dp);
			dSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static PublicKey getPublicKey(String filename) throws Exception {
	    File f = new File(filename);
	    FileInputStream fis = new FileInputStream(f);
	    DataInputStream dis = new DataInputStream(fis);
	    byte[] keyBytes = new byte[(int)f.length()];
	    dis.readFully(keyBytes);
	    dis.close();
	    X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
	    KeyFactory kf = KeyFactory.getInstance("RSA");
	    return kf.generatePublic(spec);
	}
	public static void main(String[] args) {
		String input = "16204103-张扬";
	    RSAPublicKey pubKey;
	    byte[] cipherText;
	    Cipher cipher;
	    try {
	        cipher = Cipher.getInstance("RSA");
	        pubKey = (RSAPublicKey) getPublicKey(PUBLIC_KEY_PATH);

	        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
	        cipherText = cipher.doFinal(input.getBytes());
	        //加密后的字符串
	        System.out.println("加密后的字符串: " + new String(cipherText));
	        A16204103 a = new A16204103(cipherText);
	        a.send();
	        
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	}
	


}

