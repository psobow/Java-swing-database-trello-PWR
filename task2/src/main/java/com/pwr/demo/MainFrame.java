package com.pwr.demo;

import com.pwr.demo.client.TrelloClient;
import com.pwr.demo.dto.TrelloBoardDto;
import com.pwr.demo.dto.TrelloCardDto;
import com.pwr.demo.dto.TrelloListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainFrame extends JFrame {

    @Autowired
    TrelloClient trelloClient;

    List<TrelloBoardDto> trelloBoards;

    JPanel panel = new JPanel();

    SpringLayout layout = new SpringLayout();

    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    List<JLabel> boardNameLabels = new ArrayList<>();
    List<JLabel> boardIdLabels = new ArrayList<>();

    List<JLabel> listNameLabels = new ArrayList<>();
    List<JLabel> listIdLabels = new ArrayList<>();

    List<JLabel> cardNameLabels = new ArrayList<>();


    List<JTextField> boardNameText = new ArrayList<>();
    List<JTextField> boardIdText = new ArrayList<>();

    List<JTextField> listNameText = new ArrayList<>();
    List<JTextField> listIdText = new ArrayList<>();

    List<JTextField> cardNameText = new ArrayList<>();

    private void pushToTrello(List<TrelloBoardDto> trelloBoardDtos) {
        int quantityOfLists = 0;
        int quantityOfCards = 0;

        for(int boardIndex = 0; boardIndex < trelloBoardDtos.size(); boardIndex++){

            trelloClient.putTrelloBoardName(trelloBoardDtos.get(boardIndex), boardNameText.get(boardIndex).getText());



            for(int listIndex = 0; listIndex < trelloBoardDtos.get(boardIndex).getLists().size(); listIndex++ ){
                trelloClient.putTrelloListName(trelloBoardDtos.get(boardIndex).getLists().get(listIndex),listNameText.get(quantityOfLists).getText());
                quantityOfLists++;

                for(int cardIndex = 0; cardIndex < trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getCards().size(); cardIndex++){
                    trelloClient.putTrelloCardName(trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getCards().get(cardIndex),cardNameText.get(quantityOfCards).getText());
                    quantityOfCards++;
                }
            }
        }
    }

    private void fillGUIComponents(List<TrelloBoardDto> trelloBoardDtos){

        int quantityOfLists = 0;
        int quantityOfCards = 0;

        for(int boardIndex = 0; boardIndex < trelloBoardDtos.size(); boardIndex++){
            boardIdText.get(boardIndex).setText(trelloBoardDtos.get(boardIndex).getId());
            boardNameText.get(boardIndex).setText(trelloBoardDtos.get(boardIndex).getName());



            for(int listIndex = 0; listIndex < trelloBoardDtos.get(boardIndex).getLists().size(); listIndex++ ){
                listIdText.get(quantityOfLists).setText(trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getId());
                listNameText.get(quantityOfLists).setText(trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getName());
                quantityOfLists++;

                for(int cardIndex = 0; cardIndex < trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getCards().size(); cardIndex++){
                    cardNameText.get(quantityOfCards).setText(trelloBoardDtos.get(boardIndex).getLists().get(listIndex).getCards().get(cardIndex).getName());
                    quantityOfCards++;
                }
            }
        }
    }


    private void generateGUI(List<TrelloBoardDto> trelloBoardDtos){

        boardNameLabels = new ArrayList<>();
        boardIdLabels = new ArrayList<>();

        listNameLabels = new ArrayList<>();
        listIdLabels = new ArrayList<>();

        cardNameLabels = new ArrayList<>();


        boardNameText = new ArrayList<>();
        boardIdText = new ArrayList<>();

        listNameText = new ArrayList<>();
        listIdText = new ArrayList<>();

        cardNameText = new ArrayList<>();


        for (TrelloBoardDto boardDto : trelloBoardDtos) {
            boardNameLabels.add(new JLabel("Board name: "));
            boardIdLabels.add(new JLabel("Board ID: "));

            boardNameText.add(new JTextField("Text field", 15));
            boardIdText.add(new JTextField("Text field", 15));

            for(TrelloListDto listDto : boardDto.getLists()){
                listNameLabels.add(new JLabel("List name: "));
                listIdLabels.add(new JLabel("List ID: "));

                listNameText.add(new JTextField("Text field", 15));
                listIdText.add(new JTextField("Text field", 15));


                for(TrelloCardDto cardDto : listDto.getCards()){
                    cardNameLabels.add(new JLabel("Card name: "));
                    cardNameText.add(new JTextField("Text field",15));
                }

            }

        }

        int gapBetweenBoardNameAndNorth = 5;
        int gapBetweenBoardNameAndWest = 5;

        int gapBetweenComponentsNorthSouth = 5;
        int gapBetweenComponentsWestEast = 5;

        int gapListNameAndWest = 50;

        int gapCardNameAndWest = 100;

        JComponent upperComponent = null; // always set upperComponent to previous textField

        int quantityOfLists = 0;

        int quantityOfCards = 0;

        for (int i = 0; i < trelloBoardDtos.size(); i++) {

            if (i == 0){
                layout.putConstraint(SpringLayout.WEST, boardNameLabels.get(0), gapBetweenBoardNameAndWest, SpringLayout.WEST, panel);
                layout.putConstraint(SpringLayout.NORTH, boardNameLabels.get(0), gapBetweenBoardNameAndNorth, SpringLayout.NORTH, panel);

                layout.putConstraint(SpringLayout.WEST, boardNameText.get(0), gapBetweenComponentsWestEast, SpringLayout.EAST, boardNameLabels.get(0));
                layout.putConstraint(SpringLayout.NORTH, boardNameText.get(0), gapBetweenBoardNameAndNorth, SpringLayout.NORTH, panel);

                layout.putConstraint(SpringLayout.WEST, boardIdLabels.get(0), gapBetweenComponentsWestEast, SpringLayout.EAST, boardNameText.get(0));
                layout.putConstraint(SpringLayout.NORTH, boardIdLabels.get(0), gapBetweenBoardNameAndNorth, SpringLayout.NORTH, panel);

                layout.putConstraint(SpringLayout.WEST, boardIdText.get(0), gapBetweenComponentsWestEast, SpringLayout.EAST, boardIdLabels.get(0));
                layout.putConstraint(SpringLayout.NORTH, boardIdText.get(0), gapBetweenBoardNameAndNorth, SpringLayout.NORTH, panel);

            } else {
                layout.putConstraint(SpringLayout.WEST, boardNameLabels.get(i), gapBetweenBoardNameAndWest, SpringLayout.WEST, panel);
                layout.putConstraint(SpringLayout.NORTH, boardNameLabels.get(i), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);


                layout.putConstraint(SpringLayout.WEST, boardNameText.get(i), gapBetweenComponentsWestEast, SpringLayout.EAST, boardNameLabels.get(i));
                layout.putConstraint(SpringLayout.NORTH, boardNameText.get(i), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);


                layout.putConstraint(SpringLayout.WEST, boardIdLabels.get(i), gapBetweenComponentsWestEast, SpringLayout.EAST, boardNameText.get(i));
                layout.putConstraint(SpringLayout.NORTH, boardIdLabels.get(i), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                layout.putConstraint(SpringLayout.WEST, boardIdText.get(i), gapBetweenComponentsWestEast, SpringLayout.EAST, boardIdLabels.get(i));
                layout.putConstraint(SpringLayout.NORTH, boardIdText.get(i), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

            }

            boardIdText.get(i).setEditable(false);


            panel.add(boardNameLabels.get(i));
            panel.add(boardNameText.get(i));
            panel.add(boardIdLabels.get(i));
            panel.add(boardIdText.get(i));


            upperComponent = boardIdText.get(i);


            /*
            W tej pętli zaczynam od listy na której poprzednio skończyilśmy. Dlatego j = quantityOfLists a nie j = 0. ponieważ w tedy za każdym razem odwoływalibyśmy się do tych samych list.
             */
            int listsIndex = 0;

            for( int j = quantityOfLists ; j < trelloBoardDtos.get(i).getLists().size() + quantityOfLists ; j++){

                layout.putConstraint(SpringLayout.WEST, listNameLabels.get(j), gapListNameAndWest, SpringLayout.WEST, panel);
                layout.putConstraint(SpringLayout.NORTH, listNameLabels.get(j), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                layout.putConstraint(SpringLayout.WEST, listNameText.get(j), gapBetweenComponentsWestEast, SpringLayout.EAST, listNameLabels.get(j) );
                layout.putConstraint(SpringLayout.NORTH, listNameText.get(j), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                layout.putConstraint(SpringLayout.WEST, listIdLabels.get(j), gapBetweenComponentsWestEast, SpringLayout.EAST, listNameText.get(j));
                layout.putConstraint(SpringLayout.NORTH, listIdLabels.get(j), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                layout.putConstraint(SpringLayout.WEST, listIdText.get(j), gapBetweenComponentsWestEast, SpringLayout.EAST, listIdLabels.get(j));
                layout.putConstraint(SpringLayout.NORTH, listIdText.get(j), gapBetweenComponentsWestEast, SpringLayout.SOUTH, upperComponent);


                listIdText.get(j).setEditable(false);
                panel.add(listNameLabels.get(j));
                panel.add(listNameText.get(j));
                panel.add(listIdLabels.get(j));
                panel.add(listIdText.get(j));

                upperComponent = listIdText.get(j);



                for( int k = quantityOfCards; k < trelloBoardDtos.get(i).getLists().get(listsIndex).getCards().size() + quantityOfCards; k++){
                    layout.putConstraint(SpringLayout.WEST, cardNameLabels.get(k), gapCardNameAndWest, SpringLayout.WEST, panel);
                    layout.putConstraint(SpringLayout.NORTH, cardNameLabels.get(k), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                    layout.putConstraint(SpringLayout.WEST, cardNameText.get(k), gapBetweenComponentsWestEast, SpringLayout.EAST, cardNameLabels.get(k));
                    layout.putConstraint(SpringLayout.NORTH, cardNameText.get(k), gapBetweenComponentsNorthSouth, SpringLayout.SOUTH, upperComponent);

                    panel.add(cardNameLabels.get(k));
                    panel.add(cardNameText.get(k));

                    upperComponent = cardNameText.get(k);
                }

                quantityOfCards += trelloBoardDtos.get(i).getLists().get(listsIndex).getCards().size();

                listsIndex++;
            }
            quantityOfLists += trelloBoardDtos.get(i).getLists().size();

        }
    }

    public static JTextField trelloKeyText = new JTextField("", 15);
    public static JTextField trelloTokenText = new JTextField("", 15);

    public MainFrame(){
        super("Hello World!");

        JLabel trelloKeyLabel = new JLabel("Trello key:");
        JLabel trelloTokenLabel = new JLabel("Trello token:");


        JButton buttonFetchFromTrello = new JButton("Fetch data from trello");
        JButton buttonPushToTrello = new JButton("Push data to trello");

        JButton buttonFetchFromDB = new JButton("Fetch data from DB");
        JButton buttonPushToDB = new JButton("Push data to DB");

        panel.add(trelloKeyLabel);
        panel.add(trelloTokenLabel);

        panel.add(trelloKeyText);
        panel.add(trelloTokenText);

        panel.add(buttonFetchFromTrello);
        panel.add(buttonPushToTrello);

        panel.add(buttonFetchFromDB);
        panel.add(buttonPushToDB);


        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(layout);
        panel.setSize(2000,  2000);
        add(panel);
        setSize(WIDTH,HEIGHT);
        //setPreferredSize(new Dimension(400, 400));
        //pack();



        layout.putConstraint(SpringLayout.WEST, buttonPushToTrello, 0, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, buttonPushToTrello, 0, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.WEST, buttonFetchFromTrello, 0, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, buttonFetchFromTrello, -10, SpringLayout.NORTH, buttonPushToTrello);

        layout.putConstraint(SpringLayout.EAST, buttonPushToDB, 0, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, buttonPushToDB, 0, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.EAST, buttonFetchFromDB, 0, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, buttonFetchFromDB, -10, SpringLayout.NORTH, buttonPushToDB);


        layout.putConstraint(SpringLayout.WEST, trelloKeyLabel, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, trelloKeyLabel, -40, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.WEST, trelloKeyText, 5, SpringLayout.EAST, trelloKeyLabel);
        layout.putConstraint(SpringLayout.SOUTH, trelloKeyText, -40, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.WEST, trelloTokenLabel, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, trelloTokenLabel, -15, SpringLayout.SOUTH, panel);

        layout.putConstraint(SpringLayout.WEST, trelloTokenText, 5, SpringLayout.EAST, trelloTokenLabel);
        layout.putConstraint(SpringLayout.SOUTH, trelloTokenText, -15, SpringLayout.SOUTH, panel);


        buttonFetchFromTrello.addActionListener(event -> {
            trelloBoards = trelloClient.getTrelloBoardsWithListsAndCards();
            generateGUI(trelloBoards);
            fillGUIComponents(trelloBoards);

            panel.revalidate();
            panel.repaint();
        });

        buttonPushToTrello.addActionListener(event -> {
            if (trelloBoards != null){
                pushToTrello(trelloBoards);
            }
        });


        setVisible(true);
    }
}