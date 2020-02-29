package Page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Bean.BeanFormulario;
import ConfiguracionBase.ConfigBase;
import Utilitarios.GetScreenShot;
import Utilitarios.UtilitariosButton;
import Utilitarios.UtilitariosTextField;

public class PageFormulario extends ConfigBase {
	
	//elementos
	@FindBy(name = "entry.2005620554")
	WebElement inputnombreApellido;
	
	@FindBy(name = "entry.1140037502")
	WebElement inputCorreo;
	
	//@FindBy(xpath = "//*[@id='mG61Hd']/div/div/div[3]/div[1]/div/div/span/span")
	@FindBy(xpath = "//span[contains(text(),'Siguiente')]")
	
	WebElement btnNext;
	
	@FindBy (xpath = "//span[contains(text(),'Enviar')]")
	WebElement btnEnviar;
	
	//metodo constructor
	public PageFormulario()
	{
	String baseUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfzLAD7DNf6fz1tu_gtbuyDZVbpSbeR_PNS3zOtlj416VZ1jA/viewform";
	PageFactory.initElements(driver, this); // si no se inicializan los WebElement da error de null pointer exception
	driver.get(baseUrl);
	}
	
	
	//metodo de automatizacion o negpcio
	public void registrarFormulario(ITestResult testResult,BeanFormulario beanFormulario) throws InterruptedException, IOException
	{
		UtilitariosTextField.txtField_putString(beanFormulario.getNombreApellido(), inputnombreApellido, driver, testResult);
		UtilitariosTextField.txtField_putString(beanFormulario.getCorreo(), inputCorreo, driver, testResult);
		
		GetScreenShot.capturarPantallaFile(driver, "-IngresoNombreYCorreo.png");
		UtilitariosButton.btn_clic(btnNext, driver, testResult);
		
		GetScreenShot.capturarPantallaFile(driver, "-SegundaPantalla.png");
		UtilitariosButton.btn_clic(btnEnviar, driver, testResult);
		
	}

}