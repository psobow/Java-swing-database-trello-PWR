package com.pwr.demo;

import com.pwr.demo.client.TrelloClient;
import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class MainFrame extends JFrame {

    @Autowired
    TrelloClient trelloClient;

    List<TrelloBoardDto> trelloBoards;

    private final int WIDTH = 800;
    private final int HEIGHT = 300;

    public MainFrame(){
        super("Hello World!");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define the panel to hold the components
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();

        JLabel label = new JLabel("Board name: ");
        JLabel label2 = new JLabel("Board ID: ");

        JLabel label3 = new JLabel("List name: ");
        JLabel label4 = new JLabel("List ID: ");

        JLabel label5 = new JLabel("Card name: ");
        JLabel label6 = new JLabel("Card name: ");
        JLabel label7 = new JLabel("Card name: ");


        JTextField text = new JTextField("Text field", 15);
        JTextField text2 = new JTextField("Text field", 15);
        JTextField text3 = new JTextField("Text field", 15);
        JTextField text4 = new JTextField("Text field", 15);
        JTextField text5 = new JTextField("Text field", 20);
        JTextField text6 = new JTextField("Text field", 20);
        JTextField text7 = new JTextField("Text field", 20);

        JButton button1 = new JButton("Fetch data from trello");
        JButton button2 = new JButton("Push data to trello");

        button1.addActionListener(event -> {
            trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();
            text.setText(trelloBoards.get(0).getName());
            text2.setText(trelloBoards.get(0).getId());
            text2.setEditable(false);

            text3.setText(trelloBoards.get(0).getLists().get(0).getName());
            text4.setText(trelloBoards.get(0).getLists().get(0).getId());
            text4.setEditable(false);

            text5.setText(trelloBoards.get(0).getLists().get(0).getCards().get(0).getName());
            text6.setText(trelloBoards.get(0).getLists().get(0).getCards().get(1).getName());
            text7.setText(trelloBoards.get(0).getLists().get(0).getCards().get(2).getName());
        });

        button2.addActionListener(event -> {
            trelloClient.putTrelloBoardName(trelloBoards.get(0),text.getText());

            trelloClient.putTrelloListName(trelloBoards.get(0).getLists().get(0), text3.getText());
            List<TrelloCardDto> cards = trelloBoards.get(0).getLists().get(0).getCards();

            trelloClient.putTrelloCardName(cards.get(0), text5.getText());
            trelloClient.putTrelloCardName(cards.get(1), text6.getText());
            trelloClient.putTrelloCardName(cards.get(2), text7.getText());
        });

        panel.setSize(WIDTH, HEIGHT);
        panel.setLayout(layout);
        panel.add(label);
        panel.add(text);
        panel.add(label2);
        panel.add(text2);

        panel.add(label3);
        panel.add(text3);

        panel.add(label4);
        panel.add(text4);

        panel.add(label5);
        panel.add(text5);

        panel.add(label6);
        panel.add(text6);

        panel.add(label7);
        panel.add(text7);


        panel.add(button1);
        panel.add(button2);

        // Put constraint on components

        // Board name
        layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, text, 5, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.NORTH, panel);


        // Board ID
        layout.putConstraint(SpringLayout.WEST, label2, 5, SpringLayout.EAST, text);
        layout.putConstraint(SpringLayout.NORTH, label2, 5, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, text2, 5, SpringLayout.EAST, label2);
        layout.putConstraint(SpringLayout.NORTH, text2, 5, SpringLayout.NORTH, panel);



        // List name
        layout.putConstraint(SpringLayout.WEST, label3, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label3, 5, SpringLayout.SOUTH, text);

        layout.putConstraint(SpringLayout.WEST, text3, 5, SpringLayout.EAST, label3);
        layout.putConstraint(SpringLayout.NORTH, text3, 5, SpringLayout.SOUTH, text2);



        // List ID
        layout.putConstraint(SpringLayout.WEST, label4, 5, SpringLayout.EAST, text3);
        layout.putConstraint(SpringLayout.NORTH, label4, 5, SpringLayout.SOUTH, text2);

        layout.putConstraint(SpringLayout.WEST, text4, 5, SpringLayout.EAST, label4);
        layout.putConstraint(SpringLayout.NORTH, text4, 5, SpringLayout.SOUTH, text2);



        // Cards
        layout.putConstraint(SpringLayout.WEST, label5, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label5, 5, SpringLayout.SOUTH, text4);

        layout.putConstraint(SpringLayout.WEST, text5, 5, SpringLayout.EAST, label5);
        layout.putConstraint(SpringLayout.NORTH, text5, 5, SpringLayout.SOUTH, text4);



        layout.putConstraint(SpringLayout.WEST, label6, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label6, 5, SpringLayout.SOUTH, text5);

        layout.putConstraint(SpringLayout.WEST, text6, 5, SpringLayout.EAST, label6);
        layout.putConstraint(SpringLayout.NORTH, text6, 5, SpringLayout.SOUTH, text5);


        layout.putConstraint(SpringLayout.WEST, label7, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, label7, 5, SpringLayout.SOUTH, text6);

        layout.putConstraint(SpringLayout.WEST, text7, 5, SpringLayout.EAST, label7);
        layout.putConstraint(SpringLayout.NORTH, text7, 5, SpringLayout.SOUTH, text6);









        layout.putConstraint(SpringLayout.WEST, button1, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, button1, 0, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.WEST, button2, 250, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, button2, 0, SpringLayout.SOUTH, panel);



        // Set the window to be visible as the default to be false
        add(panel);
        setSize(WIDTH,HEIGHT);
        setVisible(true);
    }
}