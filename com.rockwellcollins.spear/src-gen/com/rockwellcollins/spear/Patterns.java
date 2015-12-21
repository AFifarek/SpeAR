/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Patterns</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.Patterns#getPatterns <em>Patterns</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getPatterns()
 * @model
 * @generated
 */
public interface Patterns extends File
{
  /**
   * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Pattern}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Patterns</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPatterns_Patterns()
   * @model containment="true"
   * @generated
   */
  EList<Pattern> getPatterns();

} // Patterns
