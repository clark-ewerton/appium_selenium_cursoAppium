package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class MenuPage extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}

	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");
	}

	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}

	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}

	public void acessarSwipe() {
		int aux = 0;
		List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
		for (MobileElement element : elements) {
			if (getDriver().findElements(By.xpath("//*[@text='Swipe']")).size() == 0 && aux < 3) {
				scrollDown();
				aux++;
				if (aux == 2) {
					System.err.println("NAO ACHOU ELEMENTO");
					break;
				}
			} else {
				elements.stream().filter(item -> item.getAttribute("text").equals("Swipe"))
						.forEach(item -> item.click());
				break;
			}
		}
		clicarPorTexto("Swipe");
	}

	public void clicarSwipeList() {
		int aux = 0;
		List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
		for (MobileElement element : elements) {
			if (getDriver().findElements(By.xpath("//*[@text='Swipe List']")).size() == 0 && aux < 3) {
				scrollDown();
				aux++;
				if (aux == 2) {
					System.err.println("NAO ACHOU ELEMENTO");
					break;
				}
			} else {
				elements.stream().filter(item -> item.getAttribute("text").equals("Swipe List"))
						.forEach(item -> item.click());
				break;
			}
		}

		// List<MobileElement> elements =
		// getDriver().findElements(By.className("android.widget.TextView"));
		/*
		 * String[] retorno = new String[elements.size()]; for (int i = 0; i <
		 * elements.size(); i++) { retorno[i] = elements.get(i).getText();
		 * System.out.print("\"" + retorno[i] + "\", ");
		 * //clicarPorTexto(retorno[i].equals("Formulário") ? "Formulário" : "");
		 * 
		 * if (retorno[i].equals("Swipe List")) { System.out.println("ACHOU ELEMENTO");
		 * clicarPorTexto(retorno[i]); break; } else if(i == 9) {
		 * System.err.println("NAO ACHOU ELEMENTO"); scrollDown();
		 * clicarPorTexto("Swipe List");
		 * 
		 * } }
		 */

	}

	public void clicarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}

	public void acessarSBHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}

	public void acessarSBNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}
}
