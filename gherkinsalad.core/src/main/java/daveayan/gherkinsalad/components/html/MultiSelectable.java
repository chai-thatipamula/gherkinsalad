/**
 * Copyright (c) 2012 Ayan Dave http://daveayan.com
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, including 
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the 
 * following conditions:
 * 
 * 1) The above copyright notice and this permission notice shall be included without any changes or alterations 
 * in all copies or substantial portions of the Software.
 * 2) This software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
**/
package daveayan.gherkinsalad.components.html;

import daveayan.gherkinsalad.Strings;
/** @author daveayan */
/**
 * Interface that indicates that a browser element has multiple options from which *Multiple* can be selected. This is an interface for the Dropdowns
 * Unless absolutely needed do not make your page object implement this interface directly. Instead make them extend Dropdown.
 */
public interface MultiSelectable extends Selectable {
	/**
	 * Use this method to get the text of the currently selected options if the control allows multiple selections. If the control allows single selection this returns 
	 * a Strings object with just one string in there
	 * @return
	 */
	public Strings get_selected_options();
	
	public void should_have_these_options_selected(Strings option);
	
	public void should_have_these_codes_selected(Strings code);
	
	public void should_not_have_these_options_selected(Strings option);
	
	public void should_not_have_these_codes_selected(Strings code);
}