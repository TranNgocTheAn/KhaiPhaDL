/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import weka.associations.Apriori;
import weka.core.Instances;

/**
 *
 * @author USER
 */
public class MyAprioriModel extends MyKnowledgeModel {
    Apriori apriori;
    Instances newData;

     public MyAprioriModel() {
    }

    public MyAprioriModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.apriori = new Apriori();
    }
    
    public void mineAssociationRules() throws Exception{
        // loc du lieu
//        this.newData = removeData(this.dataset);
        this.newData = convertData(this.dataset);
        //thiet lap thong so
        apriori.setOptions(this.model_options);
        //khai pha luat ket hop
        apriori.buildAssociations(this.newData);
    }

    @Override
    public String toString() {
        return apriori.toString();
    }
    
}
