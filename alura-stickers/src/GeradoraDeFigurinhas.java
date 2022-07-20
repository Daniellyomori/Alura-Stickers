import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        //leitura da imagem
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 50;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar imagem original pra nova
        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //escrever frase em imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        graphics.drawString( "Estocolmo", 100,  novaAltura - 100);

        //escrever a nova imagem em um arquivo
        File saida = new File (nomeArquivo);
        if (! saida.exists()){
            saida.mkdirs();
        }
        ImageIO.write(novaImagem,"png", saida);        
    }
}
