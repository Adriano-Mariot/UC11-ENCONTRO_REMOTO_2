package teste.senai;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteDeNavegabilidade {

	ChromeDriver driver;
	
	// before-test

	@Before 
	public void PreTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedrive\\chromedriver.exe");
		//open browser
		this.driver = new ChromeDriver (); 
		driver.manage().window().maximize();
	}
	
	// real time test
	@Test
	public void TesteNavegador() { 
		driver.get("http://localhost:4200");
		driver.findElement(By.xpath("//*[@id=\"navMenu\"]/a[5]")).click();
		
		//Create elements
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.id("signin"));
		String[]ListEmail= {"adriano@mail.com","oliver@mail.com","mariot@mail.com"};
		String[]ListSenha= {"12345678","0","12345678"};
		
		for (int tentativas=0; tentativas<ListSenha.length;tentativas++) {
			try {
				//cleaning fields
				inputEmail.clear();
				inputSenha.clear();
				
				//fill elements
				inputEmail.sendKeys(ListEmail[tentativas]);
				inputSenha.sendKeys(ListSenha[tentativas]);
				inputSubmit.click();
				
				Thread.sleep(3000);//3segundos
				
			}catch (InterruptedException error) {
				error.printStackTrace();
			}
		}
		
	}
	
	//after test
	@After
	public void FimTest() {
		try {
			Thread.sleep(2000);//3segundos
			driver.quit();//close window
		}catch(Exception error) {
			error.printStackTrace();
		}
	}
	
}
