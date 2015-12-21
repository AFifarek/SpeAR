/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getNode <em>Node</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Pattern#getEnglish <em>English</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.Pattern#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getInputs();

  /**
   * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Variable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Outputs()
   * @model containment="true"
   * @generated
   */
  EList<Variable> getOutputs();

  /**
   * Returns the value of the '<em><b>Node</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' attribute.
   * @see #setNode(String)
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_Node()
   * @model
   * @generated
   */
  String getNode();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.Pattern#getNode <em>Node</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' attribute.
   * @see #getNode()
   * @generated
   */
  void setNode(String value);

  /**
   * Returns the value of the '<em><b>English</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>English</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>English</em>' attribute.
   * @see #setEnglish(String)
   * @see com.rockwellcollins.spear.SpearPackage#getPattern_English()
   * @model
   * @generated
   */
  String getEnglish();

  /**
   * Sets the value of the '{@link com.rockwellcollins.spear.Pattern#getEnglish <em>English</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>English</em>' attribute.
   * @see #getEnglish()
   * @generated
   */
  void setEnglish(String value);

} // Pattern
