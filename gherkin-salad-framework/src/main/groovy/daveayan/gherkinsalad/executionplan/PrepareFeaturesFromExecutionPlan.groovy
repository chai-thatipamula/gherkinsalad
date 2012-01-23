package daveayan.gherkinsalad.executionplan

import daveayan.gherkinsalad.Path

class PrepareFeaturesFromExecutionPlan {
	public static void main(String[] args) {
		PrepareFeaturesFromExecutionPlan object = new PrepareFeaturesFromExecutionPlan()
		object.run("integration-test-execution-plan.csv")
	}
	
	def run(file_name) {
		clean_and_prepare()
		process_execution_plan(file_name)
	}
	
	def clean_and_prepare() {
		def features_folder = new File("./features")
		if(features_folder.exists()) {
			features_folder.deleteDir()
		}
		features_folder.mkdir()
	}
	
	def process_execution_plan(file_name) {
		def execution_plan_file = new File(Path.TO_EXECUTION_PLAN + file_name)
		execution_plan_file.eachLine { line ->
			if(! line.startsWith("feature file")) {
				def line_items = line.split(",")
				def top_scenario_text = top_scenario_text(line_items[1], line_items[2], line_items[3], line_items[4], line_items[5], line_items[6])
				def bottom_scenario_text = bottom_scenario_text()
				process_feature_file(line_items[0], top_scenario_text, bottom_scenario_text)
			}
		}
	}
	
	def process_feature_file(feature_file_name, top_scenario_text, bottom_scenario_text) {
		def feature_file = new File(Path.TO_FEATURES + feature_file_name)
		if(feature_file.exists()) {
			println "--> Processing Feature File '${feature_file.absolutePath}'"
			def processed_content = feature_file.text.replace("#EXECUTION PLAN INSTRUCTION AT TOP", top_scenario_text);
			processed_content = processed_content.replace("#EXECUTION PLAN INSTRUCTION AT BOTTOM", bottom_scenario_text);
			
			def file_relative_path_and_name = feature_file_name.toString()
			def new_file_name = file_relative_path_and_name.replace(".feature", "_" + System.currentTimeMillis() + ".feature");

			create_intermediate_folders (file_relative_path_and_name)
			def processed_feature_file = new File("./features/" + new_file_name)
			processed_feature_file.createNewFile()
			processed_feature_file.write(processed_content);
		} else {
			println "--> File referred to by execution plan does not exist '${feature_file.absolutePath}'"
		}
	}
	
	def create_intermediate_folders(file_relative_path_and_name) {
		def path_elements = file_relative_path_and_name.split("/")
		def path_to_create = "./features/"
		path_elements.each {
			if(! it.endsWith(".feature")) {
				path_to_create += it + "/"
			}
		}
		def folders_to_create = new File(path_to_create)
		folders_to_create.mkdirs()
	}
	
	def top_scenario_text(feature_name, browser_name, page_structure_file_name, url, data_file_name, data_source_driver) {
		def scenario_text = "Scenario: Prepare browser and test data"
		scenario_text += "\n\t\tGiven User launched the " + browser_name.trim() + " browser with page structure file " + page_structure_file_name.trim()
		if(! url.trim().equals("NA")) {
			scenario_text += "\n\t\tAnd User visited website " + url.trim()
		}
		if(! data_file_name.trim().equals("NA") && ! data_source_driver.trim().equals("NA")) {
			scenario_text += "\n\t\tAnd User uses the data source file " + data_file_name.trim() + " with driver " + data_source_driver.trim()
		}
		if(! feature_name.trim().equals("NA")) {
			scenario_text += "\n\t\tAnd User is testing feature " + feature_name.trim()
		}
		return scenario_text
	}
	
	def bottom_scenario_text() {
		def bottom_scenario_text = "Scenario: Close Browser\n"
		bottom_scenario_text += "\t\tThen User closes the browser window"
		return bottom_scenario_text
	}
}