# API-s
This Repo is for the capture of API's, as well as to outline a few api templates for quick use and manipulation moving forward

-------------------------------------------------------------------
#Spring Boot Rest API To Consume Data - Step by Step
-------------------------------------------------------------------
1. Build the Model for your API

2. Replace <Name_of_Endpoint_to_call_to_trigger_api> "<Name_Of_Your_S3_Bucket>", "<Name_Of_Your_File>.<File_Extension>", "<Name_Of_Your_File>.<File_Extension>" With there respective values

3. Update Region in S3Service.java .region(Region.<Specify_Region_Here - format US_EAST_2>)

4. In Template Service Update String url = "<Your URL Here>";

5. Also in TemplateService, we will need to add all of the data points we are consuming(will mimmic your model) and made edits so we can properly write to file
writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");

6. Modify CICD Pipeline to Modify the Image name