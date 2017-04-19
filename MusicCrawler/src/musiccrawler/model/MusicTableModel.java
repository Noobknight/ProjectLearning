/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiccrawler.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tavv
 */
public class MusicTableModel extends AbstractTableModel {

    private final String[] columName;
    private final List<Music> musics;

    public MusicTableModel(String[] columName, List<Music> musics) {
        this.columName = columName;
        this.musics = musics;
    }

    @Override
    public int getRowCount() {
        return musics.size();
    }

    @Override
    public int getColumnCount() {
        return columName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return musics.get(rowIndex);
    }

}
