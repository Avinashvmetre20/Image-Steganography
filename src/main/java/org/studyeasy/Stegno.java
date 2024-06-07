package org.studyeasy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stegno {

    private JFrame frame;
    private BufferedImage originalImage;

    public Stegno() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Image Steganography");
        frame.setBounds(100, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Image Steganography");
        titleLabel.setFont(new Font("Courier", Font.PLAIN, 28));
        titleLabel.setBounds(10, 10, 480, 40);
        frame.getContentPane().add(titleLabel);

        JButton encodeButton = new JButton("Encode");
        encodeButton.setFont(new Font("Courier", Font.PLAIN, 14));
        encodeButton.setBounds(150, 80, 200, 30);
        encodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEncodeFrame();
            }
        });
        frame.getContentPane().add(encodeButton);

        JButton decodeButton = new JButton("Decode");
        decodeButton.setFont(new Font("Courier", Font.PLAIN, 14));
        decodeButton.setBounds(150, 130, 200, 30);
        decodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDecodeFrame();
            }
        });
        frame.getContentPane().add(decodeButton);

        JLabel asciiArtLabel1 = new JLabel("<html>¯\\_(ツ)_/¯<br></html>");
        asciiArtLabel1.setFont(new Font("Courier", Font.PLAIN, 12));
        asciiArtLabel1.setBounds(10, 180, 480, 100);
        frame.getContentPane().add(asciiArtLabel1);

        JLabel asciiArtLabel2 = new JLabel("<html>(\\(°Ω°)/)<br>\\(°-°)/<br></html>");
        asciiArtLabel2.setFont(new Font("Courier", Font.PLAIN, 12));
        asciiArtLabel2.setBounds(10, 280, 480, 100);
        frame.getContentPane().add(asciiArtLabel2);

        frame.setVisible(true);
    }

    private void showEncodeFrame() {
        JFrame encodeFrame = new JFrame();
        encodeFrame.setTitle("Encode Message");
        encodeFrame.setBounds(100, 100, 500, 700);
        encodeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        encodeFrame.getContentPane().setLayout(null);

        JLabel labelArt = new JLabel("'\\(°Ω°)/'");
        labelArt.setFont(new Font("Courier", Font.PLAIN, 70));
        labelArt.setBounds(10, 10, 480, 100);
        encodeFrame.getContentPane().add(labelArt);

        JLabel selectLabel = new JLabel("Select the Image in which you want to hide text:");
        selectLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        selectLabel.setBounds(10, 120, 480, 30);
        encodeFrame.getContentPane().add(selectLabel);

        JButton selectButton = new JButton("Select");
        selectButton.setFont(new Font("Courier", Font.PLAIN, 18));
        selectButton.setBounds(150, 160, 200, 30);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectImageForEncode(encodeFrame);
            }
        });
        encodeFrame.getContentPane().add(selectButton);

        JButton backButton = new JButton("Cancel");
        backButton.setFont(new Font("Courier", Font.PLAIN, 18));
        backButton.setBounds(150, 200, 200, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encodeFrame.dispose();
            }
        });
        encodeFrame.getContentPane().add(backButton);

        encodeFrame.setVisible(true);
    }

    private void showDecodeFrame() {
        JFrame decodeFrame = new JFrame();
        decodeFrame.setTitle("Decode Message");
        decodeFrame.setBounds(100, 100, 500, 700);
        decodeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        decodeFrame.getContentPane().setLayout(null);

        JLabel labelArt = new JLabel("٩(^‿^)۶");
        labelArt.setFont(new Font("Courier", Font.PLAIN, 90));
        labelArt.setBounds(10, 10, 480, 100);
        decodeFrame.getContentPane().add(labelArt);

        JLabel selectLabel = new JLabel("Select Image with Hidden text:");
        selectLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        selectLabel.setBounds(10, 120, 480, 30);
        decodeFrame.getContentPane().add(selectLabel);

        JButton selectButton = new JButton("Select");
        selectButton.setFont(new Font("Courier", Font.PLAIN, 18));
        selectButton.setBounds(150, 160, 200, 30);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectImageForDecode(decodeFrame);
            }
        });
        decodeFrame.getContentPane().add(selectButton);

        JButton backButton = new JButton("Cancel");
        backButton.setFont(new Font("Courier", Font.PLAIN, 18));
        backButton.setBounds(150, 200, 200, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decodeFrame.dispose();
            }
        });
        decodeFrame.getContentPane().add(backButton);

        decodeFrame.setVisible(true);
    }

    private void selectImageForEncode(JFrame encodeFrame) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                originalImage = ImageIO.read(selectedFile);

                JFrame encodeTextFrame = new JFrame();
                encodeTextFrame.setTitle("Encode Message");
                encodeTextFrame.setBounds(100, 100, 500, 700);
                encodeTextFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                encodeTextFrame.getContentPane().setLayout(null);

                JLabel selectedImageLabel = new JLabel("Selected Image:");
                selectedImageLabel.setFont(new Font("Courier", Font.PLAIN, 18));
                selectedImageLabel.setBounds(10, 10, 480, 30);
                encodeTextFrame.getContentPane().add(selectedImageLabel);

                ImageIcon imageIcon = new ImageIcon(originalImage.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
                JLabel imageLabel = new JLabel(imageIcon);
                JScrollPane scrollPane = new JScrollPane(imageLabel);
                scrollPane.setBounds(10, 50, 460, 200);
                encodeTextFrame.getContentPane().add(scrollPane);

                JLabel messageLabel = new JLabel("Enter the message:");
                messageLabel.setFont(new Font("Courier", Font.PLAIN, 18));
                messageLabel.setBounds(10, 260, 480, 30);
                encodeTextFrame.getContentPane().add(messageLabel);

                JTextArea textArea = new JTextArea();
                textArea.setBounds(10, 300, 460, 100);
                encodeTextFrame.getContentPane().add(textArea);

                JButton encodeButton = new JButton("Encode");
                encodeButton.setFont(new Font("Courier", Font.PLAIN, 14));
                encodeButton.setBounds(150, 420, 200, 30);
                encodeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        encodeMessage(textArea.getText(), encodeTextFrame);
                    }
                });
                encodeTextFrame.getContentPane().add(encodeButton);

                encodeFrame.dispose();
                encodeTextFrame.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error loading image.");
            }
        }
    }

    private void selectImageForDecode(JFrame decodeFrame) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedFile);
                String hiddenData = decodeMessage(image);

                JFrame decodedMessageFrame = new JFrame();
                decodedMessageFrame.setTitle("Decoded Message");
                decodedMessageFrame.setBounds(100, 100, 500, 700);
                decodedMessageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                decodedMessageFrame.getContentPane().setLayout(null);

                JLabel selectedImageLabel = new JLabel("Selected Image:");
                selectedImageLabel.setFont(new Font("Courier", Font.PLAIN, 18));
                selectedImageLabel.setBounds(10, 10, 480, 30);
                decodedMessageFrame.getContentPane().add(selectedImageLabel);

                ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(300, 200, Image.SCALE_SMOOTH));
                JLabel imageLabel = new JLabel(imageIcon);
                JScrollPane scrollPane = new JScrollPane(imageLabel);
                scrollPane.setBounds(10, 50, 460, 200);
                decodedMessageFrame.getContentPane().add(scrollPane);

                JLabel messageLabel = new JLabel("Hidden data is:");
                messageLabel.setFont(new Font("Courier", Font.PLAIN, 18));
                messageLabel.setBounds(10, 260, 480, 30);
                decodedMessageFrame.getContentPane().add(messageLabel);

                JTextArea textArea = new JTextArea();
                textArea.setText(hiddenData);
                textArea.setBounds(10, 300, 460, 100);
                textArea.setEditable(false);
                decodedMessageFrame.getContentPane().add(textArea);

                decodeFrame.dispose();
                decodedMessageFrame.setVisible(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error loading image.");
            }
        }
    }

    private String decodeMessage(BufferedImage image) {
        StringBuilder data = new StringBuilder();
        int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        for (int i = 0; i < pixels.length; i += 3) {
            int[] rgb = new int[9];
            for (int j = 0; j < 3; j++) {
                rgb[j * 3] = (pixels[i + j] >> 16) & 0xFF;
                rgb[j * 3 + 1] = (pixels[i + j] >> 8) & 0xFF;
                rgb[j * 3 + 2] = pixels[i + j] & 0xFF;
            }
            StringBuilder binstr = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                binstr.append(rgb[j] % 2 == 0 ? '0' : '1');
            }
            data.append((char) Integer.parseInt(binstr.toString(), 2));
            if (rgb[8] % 2 != 0) break;
        }
        return data.toString();
    }

    private void encodeMessage(String message, JFrame encodeTextFrame) {
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter text in the text box.");
        } else {
            try {
                BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = newImage.getGraphics();
                g.drawImage(originalImage, 0, 0, null);
                g.dispose();
                encodeImage(newImage, message);

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File("Image_with_hidden_text.png"));
                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File outputfile = fileChooser.getSelectedFile();
                    ImageIO.write(newImage, "png", outputfile);
                    JOptionPane.showMessageDialog(null, "Encoding successful. File is saved as " + outputfile.getName());
                    encodeTextFrame.dispose();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving image.");
            }
        }
    }

    private void encodeImage(BufferedImage newImage, String message) {
        int[] pixels = newImage.getRGB(0, 0, newImage.getWidth(), newImage.getHeight(), null, 0, newImage.getWidth());
        char[] msgChars = message.toCharArray();
        int msgIndex = 0;
        int bitIndex = 0;
        for (int i = 0; i < pixels.length; i += 3) {
            int[] rgb = new int[9];
            for (int j = 0; j < 3; j++) {
                rgb[j * 3] = (pixels[i + j] >> 16) & 0xFF;
                rgb[j * 3 + 1] = (pixels[i + j] >> 8) & 0xFF;
                rgb[j * 3 + 2] = pixels[i + j] & 0xFF;
            }
            for (int j = 0; j < 8; j++) {
                if (bitIndex < msgChars.length * 8) {
                    int bit = (msgChars[msgIndex] >> (7 - (bitIndex % 8))) & 1;
                    rgb[j] = (rgb[j] & 0xFE) | bit;
                    bitIndex++;
                    if (bitIndex % 8 == 0) msgIndex++;
                } else {
                    rgb[j] = (rgb[j] & 0xFE);
                }
            }
            if (bitIndex >= msgChars.length * 8) {
                rgb[8] = (rgb[8] & 0xFE) | 1;
                for (int j = 0; j < 3; j++) {
                    int pixel = (rgb[j * 3] << 16) | (rgb[j * 3 + 1] << 8) | rgb[j * 3 + 2];
                    pixels[i + j] = pixel;
                }
                break;
            } else {
                rgb[8] = (rgb[8] & 0xFE);
            }
            for (int j = 0; j < 3; j++) {
                int pixel = (rgb[j * 3] << 16) | (rgb[j * 3 + 1] << 8) | rgb[j * 3 + 2];
                pixels[i + j] = pixel;
            }
        }
        newImage.setRGB(0, 0, newImage.getWidth(), newImage.getHeight(), pixels, 0, newImage.getWidth());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Stegno window = new Stegno();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
