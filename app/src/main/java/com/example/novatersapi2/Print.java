package com.example.novatersapi2;

public class Print {

    String url;
    String category;
    String print; //use "title" key


    public Print(String url, String category, String print) {
        this.print = url;
        this.url = category;
        this.category = print;
    }
//    public fromStringToArrayList(String fullPrintString) {
//        for (int i = 0; i < fullPrintString.length(); i++){
//            if (fullPrintString.indexOf('url'));
//        }
//        this.print = print;
//        this.url = url;
//    }
    public Print(String fullPrintString) {
//        for (int i = 0; i < fullPrintString.length(); i++){

        //String printName = fullPrintString.substring(0, fullPrintString.indexOf(',')); //from 0 to the first comma to get first print
        //or
        this.url = fullPrintString.substring(fullPrintString.indexOf(':') + 1, fullPrintString.indexOf(','));
        this.category = fullPrintString.substring(fullPrintString.indexOf(":") + 79, fullPrintString.indexOf("field_model_keywords") -2);
        //fullPrintString.indexOf(',') +53
        this.print = fullPrintString.substring(fullPrintString.indexOf(":") + 100, fullPrintString.indexOf("field_model_download_files:") -2);

//        String print_tag =  fullPrintString.substring(fullPrintString.indexOf(',') + 1, fullPrintString.indexOf(','));

    }
}

//JSON:{"url":"https:\/\/3dprint.nih.gov\/discover\/3dpx-000914","field_model_category_tag":"Proteins, Macromolecules and Viruses","field_model_keywords":["peptide","secondary structure","ALPHA HELIX","beta sheet","protein folding","HYDROGEN BONDING","Ramachandran plot","dihedral angles"],"field_model_3d_model_file":["https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Amide_Unit.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Alpha_Carbon_Unit.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Methyl_Group_Unit.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Helix_Template.stl"],"field_model_download_files":["https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Amide_Unit_0.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Alpha_Carbon_Unit_0.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Methyl_Group_Unit_0.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Helix_Template_0.stl","https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/3DPX-000914.zip"],"field_model_license":"Array","field_model_x3d":["<div  class=\"ds-1col entity entity-field-collection-item field-collection-item-field-model-x3d-files view-mode-view_mode_x3d_download clearfix\">\n\n  \n  \n<div class=\"field field-name-field-model-x3d-download-files field-type-file field-label-hidden\">\n    <div class=\"field-items\">\n  \t  \t\t  \t\t\t<div class=\"field-item even\"><span class=\"file\"><img class=\"file-icon\" alt=\"Binary Data\" title=\"application\/octet-stream\" src=\"\/modules\/file\/icons\/application-octet-stream.png\" \/> <a href=\"https:\/\/3dprint.nih.gov\/sites\/default\/files\/models\/3d_model_files\/Peppytide_Amide_Unit_0.x3d\" type=\"application\/octet-stream; length=1080992\">Peppytide_Amide_Unit.x3d<\/a><\/span><\/div>\n  \t\t  \t  <\/div>\n<\/div>\n\n<\/div>\n\n"],"nid":"2891","title":"Peppytides: a foldable model of the polypeptide chain","field_model_model_id":"000914","field_model_nih_verified":"0","field_model_dicom_threshold":[],"field_model_contour_level":[""],"field_model_emdb_id":[""],"field_model_pdb_id":[],"field_model_description":"Build a super accurate, scaled 3D-model of a polypeptide chain that can be folded into all the basic protein structures, like α-helices, β-sheets, and β-turns. The model, called a Peppytide, is made by linking together many 3D-printed molecular subunits with a series of precisely placed magnets and screws. Once built, the Peppytide chain faithfully reproduces the size, shape and flexibility of proteins. When it is carefully folded into the protein helix and sheet structures, the model becomes locked in by all the magnets and becomes quite rigid. &nbsp;A great way to learn about protein folding and protein secondary structures!\r\n\r\nThe model consists of three repeating elements: an amide unit, an alpha carbon unit and a side chain methyl unit. &nbsp;There is a separate stl file provided for each of these parts. &nbsp;These parts require assembly and access to a drill press and basic tools is required. &nbsp;For more information on how to assemble these parts into the final model, please see the following article:&nbsp;http:\/\/makezine.com\/projects\/peppytides\/\r\n\r\n&nbsp;\r\n","field_model_model_color":["monochrome"],"field_model_model_origin":"custom_illustration_cartoon","field_model_associated_species":[""],"field_model_experimental_method":[""],"field_model_molecular_weight":[""],"field_model_sample":[""],"field_model_resolution":[""],"field_model_resolution_units":[""],"field_model_oligomeric_details":[""],"field_model_r_factor":[""],"field_model_uniprot_reference":[""],"field_model_contour_level_1":[""],"field_model_field_of_study":[],"field_model_scattering_type":[""],"field_model_x_dimension":[""],"field_model_x_spacing":[""