/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testClustering;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Cluster;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author K
 */
public class TestClustering1 {

    public static void main(String[] args) {

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        File file = new File("C:\\Users\\K\\Documents\\Document Lagu");
        index.readDirectory(file);
        JOptionPane.showMessageDialog(null, "Documents Opened");
        // bikin dictionary
        index.makeDictionaryWithTermNumber();
        // bikin preclustering
        index.preClustering();
        for (int i = 0; i < index.getDocuments().size(); i++) {
            ArrayList<Posting> listPosting = 
                    index.getDocuments().get(i).getListOfClusteringPosting();
            System.out.println("IdDoc = "+index.getDocuments().get(i).getId()+index.getDocuments().get(i).getTitle());
            for (int j = 0; j < listPosting.size(); j++) {
                System.out.println(listPosting.get(j));
            }
        
        }
        index.clustering();
        
        for (int i = 0; i < index.getListOfCluster().size(); i++) {
            Cluster cluster = index.getListOfCluster().get(i);
            System.out.println("cluster : " + cluster.getIdCluster()+1);
            System.out.println("Member : ");
            for (int j = 0; j < cluster.getMember().size(); j++) {
                System.out.println(cluster.getMember().get(j).getId());
            }
            System.out.println("");
        }
    }
}
