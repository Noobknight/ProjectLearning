/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import musiccrawler.common.Utils;
import musiccrawler.constant.Constant;
import musiccrawler.jframe.listener.OnCloseFrameListener;
import musiccrawler.model.Music;
import musiccrawler.validate.Validator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author PC
 */
public class App extends javax.swing.JFrame implements OnCloseFrameListener, ActionListener, DocumentListener {

    private static final String QUERY_ALL_ACTION = "Query All Music";
    private static final String QUERY_OPTION = "Query With Option";
    private Map<String, String> dataCallBack;
    private final String[] COLUMN_NAMES = {"Index", "Music Id", "Title", "Image", "Url", "Lyric", "Description", "Stream", "Quality", "Name", "Age", "Description", "Avatar"};
    private final String[] COLUMN_STREAM = {"Index", "Id", "Stream"};
    private MusicCrawler musicCrawler;
    private boolean isQueryFrameVisible;

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        init();
        settingComponents();
    }

    private void settingComponents() {
        configPositionApp();
        rdgOptionCrawl.add(rdbGetAll);
        rdgOptionCrawl.add(rdbOnlyStream);
        rdgQuery.add(rdbQueryAll);
        rdgQuery.add(rdbQueryOption);
        tbResult.setVisible(false);
        rdbQueryAll.addActionListener(this);
        rdbQueryOption.addActionListener(this);
        txtUrlInput.getDocument().addDocumentListener(this);
    }

    private void init() {
        musicCrawler = new MusicCrawler();
        musicCrawler.init();
    }

    private void configPositionApp() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdgOptionCrawl = new javax.swing.ButtonGroup();
        rdgQuery = new javax.swing.ButtonGroup();
        lblAppName = new javax.swing.JLabel();
        appTab = new javax.swing.JTabbedPane();
        pnlCrawl = new javax.swing.JPanel();
        txtUrlInput = new javax.swing.JTextField();
        lblInputUrl = new javax.swing.JLabel();
        rdbGetAll = new javax.swing.JRadioButton();
        rdbOnlyStream = new javax.swing.JRadioButton();
        btnCrawl = new javax.swing.JButton();
        scrollResultCrawlOnl = new javax.swing.JScrollPane();
        tbResultCrawlOnl = new javax.swing.JTable();
        lblLoading = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        pnlQuery = new javax.swing.JPanel();
        btnQuery = new javax.swing.JButton();
        scrollResult = new javax.swing.JScrollPane();
        tbResult = new javax.swing.JTable();
        rdbQueryAll = new javax.swing.JRadioButton();
        rdbQueryOption = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblAppName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAppName.setForeground(new java.awt.Color(51, 153, 255));
        lblAppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppName.setText("CSN Crawler");

        lblInputUrl.setForeground(new java.awt.Color(0, 102, 255));
        lblInputUrl.setText("URL/Path");
        lblInputUrl.setName(""); // NOI18N

        rdbGetAll.setSelected(true);
        rdbGetAll.setText("All");

        rdbOnlyStream.setText("Only Stream");

        btnCrawl.setText("Crawl");
        btnCrawl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrawlActionPerformed(evt);
            }
        });

        tbResultCrawlOnl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbResultCrawlOnl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollResultCrawlOnl.setViewportView(tbResultCrawlOnl);

        lblError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlCrawlLayout = new javax.swing.GroupLayout(pnlCrawl);
        pnlCrawl.setLayout(pnlCrawlLayout);
        pnlCrawlLayout.setHorizontalGroup(
            pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrawlLayout.createSequentialGroup()
                .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCrawlLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblInputUrl)
                        .addGap(18, 18, 18)
                        .addComponent(txtUrlInput, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCrawlLayout.createSequentialGroup()
                        .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCrawlLayout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(rdbGetAll)
                                .addGap(26, 26, 26)
                                .addComponent(rdbOnlyStream))
                            .addGroup(pnlCrawlLayout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(btnCrawl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(132, 132, 132)
                        .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollResultCrawlOnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE))
        );
        pnlCrawlLayout.setVerticalGroup(
            pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrawlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUrlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInputUrl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbGetAll)
                    .addComponent(rdbOnlyStream))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrawl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(272, 272, 272))
            .addGroup(pnlCrawlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCrawlLayout.createSequentialGroup()
                    .addGap(0, 115, Short.MAX_VALUE)
                    .addComponent(scrollResultCrawlOnl, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlCrawlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblError, txtUrlInput});

        appTab.addTab("Crawl", pnlCrawl);

        btnQuery.setText("Query");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        tbResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbResult.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollResult.setViewportView(tbResult);

        rdbQueryAll.setText("Query All Music");

        rdbQueryOption.setText("Query With Option");

        javax.swing.GroupLayout pnlQueryLayout = new javax.swing.GroupLayout(pnlQuery);
        pnlQuery.setLayout(pnlQueryLayout);
        pnlQueryLayout.setHorizontalGroup(
            pnlQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollResult, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlQueryLayout.createSequentialGroup()
                .addGroup(pnlQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQueryLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(rdbQueryAll)
                        .addGap(26, 26, 26)
                        .addComponent(rdbQueryOption))
                    .addGroup(pnlQueryLayout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(btnQuery)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        pnlQueryLayout.setVerticalGroup(
            pnlQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbQueryAll)
                    .addComponent(rdbQueryOption))
                .addGap(18, 18, 18)
                .addComponent(btnQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollResult, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        appTab.addTab("Query", pnlQuery);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appTab)
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(lblAppName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAppName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appTab, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrawlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrawlActionPerformed
        if (Utils.isNull(rdgOptionCrawl.getSelection())) {
            JOptionPane.showMessageDialog(this, "Plz, check option before perform action crawl");
            return;
        }
        String path = txtUrlInput.getText();
        if (StringUtils.isEmpty(path)) {
            lblError.setText("Path is require");
            lblError.setForeground(Color.RED);
            return;
        }
        boolean isGetAll = rdbGetAll.isSelected();
        path = Validator.validPath(path);
        final DefaultTableModel defaultTableModel = new DefaultTableModel(isGetAll ? COLUMN_NAMES : COLUMN_STREAM, 0);
        AtomicInteger count = new AtomicInteger();
        if (isGetAll) {
            List<Music> musics = musicCrawler.crawl(path);
            if (CollectionUtils.isNotEmpty(musics)) {
                musics.forEach(music -> {
                    Object[] row = {count.getAndIncrement(), music.getId(), music.getTitle(), music.getImage(), music.getUrl(), music.getLyric(), music.getDescription(), music.getStream(), music.getQualityType().toString(), music.getSinger().getName(), music.getSinger().getAge(), music.getSinger().getDescription(), music.getSinger().getAvatar()};
                    defaultTableModel.addRow(row);
                });
            }
        } else {
            Map<String, List<String>> results = musicCrawler.reCrawlLinkStream(path);
            List<String> musicIds = results.get("id");
            List<String> listStream = results.get("stream");
            musicIds.forEach(id -> {
                int index = count.getAndIncrement();
                Object[] row = {index, id, listStream.get(index)};
                defaultTableModel.addRow(row);
            });
        }
        tbResultCrawlOnl.setModel(defaultTableModel);
        defaultTableModel.fireTableDataChanged();
        tbResultCrawlOnl.setVisible(true);
    }//GEN-LAST:event_btnCrawlActionPerformed

    private JPanel loadingPanel() {
        JPanel panel = new JPanel();
        BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(layoutMgr);
        ClassLoader cldr = this.getClass().getClassLoader();
        java.net.URL imageURL = cldr.getResource("image/ajax-loader.gif");
        ImageIcon imageIcon = new ImageIcon(imageURL);
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(imageIcon);
        imageIcon.setImageObserver(iconLabel);
        JLabel label = new JLabel("Loading...");
        panel.add(iconLabel);
        panel.add(label);
        return panel;
    }

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryActionPerformed
        if (Utils.isNull(rdgQuery.getSelection())) {
            JOptionPane.showMessageDialog(this, "Plz, check option before perform action query");
            return;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(COLUMN_NAMES, 0);
        boolean isQueryGetAll = rdbQueryAll.isSelected();
        if (isQueryGetAll) {
            getAllMusic(defaultTableModel);
        } else {
            getMusicByOption(dataCallBack, defaultTableModel);
        }

    }//GEN-LAST:event_btnQueryActionPerformed

    private void getMusicByOption(Map<String, String> values, DefaultTableModel defaultTableModel) {
        List<Music> musics = musicCrawler.getMusicByOption(values);
        if (!CollectionUtils.isEmpty(musics)) {
            AtomicInteger count = new AtomicInteger();
            musics.forEach(music -> {
                Object[] row = {count.getAndIncrement(), music.getId(), music.getTitle(), music.getImage(), music.getUrl(), music.getLyric(), music.getDescription(), music.getStream(), music.getQualityType().toString(), music.getSinger().getName(), music.getSinger().getAge(), music.getSinger().getDescription(), music.getSinger().getAvatar()};
                defaultTableModel.addRow(row);
            });
            tbResult.setModel(defaultTableModel);
            defaultTableModel.fireTableDataChanged();
            tbResult.setVisible(true);
        }
    }

    private void getAllMusic(DefaultTableModel defaultTableModel) {
        List<Music> musics = musicCrawler.getAllMusic();
        if (CollectionUtils.isNotEmpty(musics)) {
            AtomicInteger count = new AtomicInteger();
            musics.forEach(music -> {
                Object[] row = {count.getAndIncrement(), music.getId(), music.getTitle(), music.getImage(), music.getUrl(), music.getLyric(), music.getDescription(), music.getStream(), music.getQualityType().toString(), music.getSinger().getName(), music.getSinger().getAge(), music.getSinger().getDescription(), music.getSinger().getAvatar()};
                defaultTableModel.addRow(row);
            });
            tbResult.setModel(defaultTableModel);
            defaultTableModel.fireTableDataChanged();
            tbResult.setVisible(true);
        }
    }

    private void configVisibleFrameQuery(boolean isShowFrame) {
        isQueryFrameVisible = isShowFrame;
        if (isShowFrame) {
            QueryOption queryOption = new QueryOption();
            queryOption.setReceiveDataListener(this);
            queryOption.setVisible(true);
            setLocationRelativeTo(null);
        }

    }

    @Override
    public void onDataReceive(Object object) {
        if (object instanceof Map) {
            dataCallBack = (Map<String, String>) object;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton) {
            JRadioButton source = (JRadioButton) e.getSource();
            switch (source.getActionCommand()) {
                case QUERY_ALL_ACTION:
                    break;
                case QUERY_OPTION:
                    configVisibleFrameQuery(true);
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane appTab;
    private javax.swing.JButton btnCrawl;
    private javax.swing.JButton btnQuery;
    private javax.swing.JLabel lblAppName;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblInputUrl;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JPanel pnlCrawl;
    private javax.swing.JPanel pnlQuery;
    private javax.swing.JRadioButton rdbGetAll;
    private javax.swing.JRadioButton rdbOnlyStream;
    private javax.swing.JRadioButton rdbQueryAll;
    private javax.swing.JRadioButton rdbQueryOption;
    private javax.swing.ButtonGroup rdgOptionCrawl;
    private javax.swing.ButtonGroup rdgQuery;
    private javax.swing.JScrollPane scrollResult;
    private javax.swing.JScrollPane scrollResultCrawlOnl;
    private javax.swing.JTable tbResult;
    private javax.swing.JTable tbResultCrawlOnl;
    private javax.swing.JTextField txtUrlInput;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(e.getLength() > 0){
            lblError.setText(Constant.EMPTY);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

}
