import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buildUI();
        showAllContacts();
        resultsArea.setText("Search results will show here.\n");
    }

    private void buildUI() {
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());

        searchField = new JTextField(18);

        JButton firstBtn = new JButton("First Name");
        JButton lastBtn = new JButton("Last Name");
        JButton userBtn = new JButton("Username");
        JButton domainBtn = new JButton("Domain Name");
        JButton extBtn = new JButton("Extension");

        firstBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchFirstName();
            }
        });

        lastBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchLastName();
            }
        });

        userBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchUsername();
            }
        });

        domainBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchDomainName();
            }
        });

        extBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchExtension();
            }
        });

        top.add(new JLabel("Search:"));
        top.add(searchField);
        top.add(firstBtn);
        top.add(lastBtn);
        top.add(userBtn);
        top.add(domainBtn);
        top.add(extBtn);

        add(top, BorderLayout.NORTH);

        allContactsArea = new JTextArea();
        allContactsArea.setEditable(false);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2));

        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("All Contacts:"), BorderLayout.NORTH);
        left.add(new JScrollPane(allContactsArea), BorderLayout.CENTER);

        JPanel right = new JPanel(new BorderLayout());
        right.add(new JLabel("Search Results:"), BorderLayout.NORTH);
        right.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        center.add(left);
        center.add(right);

        add(center, BorderLayout.CENTER);
    }

    private void showAllContacts() {
        String text = "";
        for (int i = 0; i < myList.length; i++) {
            text += myList[i].toString() + "\n";
        }
        allContactsArea.setText(text);
    }

    private String getSearchText() {
        return searchField.getText().trim();
    }

    private void showMatches(String matches) {
        if (matches.length() == 0) {
            resultsArea.setText("No matches found.\n");
        } else {
            resultsArea.setText(matches);
        }
    }

    private void searchFirstName() {
        String target = getSearchText();
        String matches = "";

        for (int i = 0; i < myList.length; i++) {
            if (myList[i].getFirstName().equalsIgnoreCase(target)) {
                matches += myList[i].toString() + "\n";
            }
        }
        showMatches(matches);
    }

    private void searchLastName() {
        String target = getSearchText();
        String matches = "";

        for (int i = 0; i < myList.length; i++) {
            if (myList[i].getLastName().equalsIgnoreCase(target)) {
                matches += myList[i].toString() + "\n";
            }
        }
        showMatches(matches);
    }

    private void searchUsername() {
        String target = getSearchText();
        String matches = "";

        for (int i = 0; i < myList.length; i++) {
            if (myList[i].getEmailUsername().equalsIgnoreCase(target)) {
                matches += myList[i].toString() + "\n";
            }
        }
        showMatches(matches);
    }

    private void searchDomainName() {
        String target = getSearchText();
        String matches = "";

        for (int i = 0; i < myList.length; i++) {
            if (myList[i].getEmailDomainName().equalsIgnoreCase(target)) {
                matches += myList[i].toString() + "\n";
            }
        }
        showMatches(matches);
    }

    private void searchExtension() {
        String target = getSearchText();
        String matches = "";

        for (int i = 0; i < myList.length; i++) {
            if (myList[i].getEmailDomainExtension().equalsIgnoreCase(target)) {
                matches += myList[i].toString() + "\n";
            }
        }
        showMatches(matches);
    }
}
