import java.awt.*;
import javax.swing.*;

public class Screen extends JFrame {

    private Contact[] myList;

    private JTextArea allContactsArea;
    private JTextArea resultsArea;
    private JTextField searchField;

    public Screen() {
        myList = new Contact[10];

        myList[0] = new Contact("John", "Smith", "john.smith@gmail.com");
        myList[1] = new Contact("Jane", "Doe", "janed@gmail.com");
        myList[2] = new Contact("George", "Washington", "gwashington@mvla.net");
        myList[3] = new Contact("Jennifer", "Smith", "1111111@mvla.net");
        myList[4] = new Contact("Andrew", "Lee", "alee@umn.edu");
        myList[5] = new Contact("Maya", "Patel", "maya.patel@yahoo.com");
        myList[6] = new Contact("Chris", "Johnson", "cjohnson@company.org");
        myList[7] = new Contact("Sofia", "Garcia", "sofia.g@mvla.net");
        myList[8] = new Contact("Ethan", "Brown", "ethanb@gmail.com");
        myList[9] = new Contact("Olivia", "Kim", "olivia.kim@school.edu");

        setTitle("Contact Search");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        refreshAllContacts();
    }

    private void setupUI() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);

        JButton firstNameBtn = new JButton("First Name");
        JButton lastNameBtn = new JButton("Last Name");
        JButton usernameBtn = new JButton("Username");
        JButton domainNameBtn = new JButton("Domain Name");
        JButton extensionBtn = new JButton("Extension");

        firstNameBtn.addActionListener(e -> searchByType("first"));
        lastNameBtn.addActionListener(e -> searchByType("last"));
        usernameBtn.addActionListener(e -> searchByType("username"));
        domainNameBtn.addActionListener(e -> searchByType("domain"));
        extensionBtn.addActionListener(e -> searchByType("ext"));

        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(firstNameBtn);
        topPanel.add(lastNameBtn);
        topPanel.add(usernameBtn);
        topPanel.add(domainNameBtn);
        topPanel.add(extensionBtn);

        add(topPanel, BorderLayout.NORTH);

        allContactsArea = new JTextArea();
        allContactsArea.setEditable(false);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("All Contacts:"), BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(allContactsArea), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Search Results:"), BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void refreshAllContacts() {
        StringBuilder sb = new StringBuilder();
        for (Contact c : myList) {
            sb.append(c.toString()).append("\n");
        }
        allContactsArea.setText(sb.toString());
    }

    private void searchByType(String type) {
        String input = searchField.getText().trim().toLowerCase();

        if (input.length() == 0) {
            resultsArea.setText("Type something to search.\n");
            return;
        }

        StringBuilder results = new StringBuilder();

        for (Contact c : myList) {
            String value = "";

            if (type.equals("first")) {
                value = c.getFirstName();
            } else if (type.equals("last")) {
                value = c.getLastName();
            } else if (type.equals("username")) {
                value = c.getUsername();
            } else if (type.equals("domain")) {
                value = c.getDomainName();
            } else if (type.equals("ext")) {
                value = c.getDomainExtension();
            }

            if (value.toLowerCase().equals(input)) {
                results.append(c.toString()).append("\n");
            }
        }

        if (results.length() == 0) {
            resultsArea.setText("No matches found.\n");
        } else {
            resultsArea.setText(results.toString());
        }
    }
}