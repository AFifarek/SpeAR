/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.Definitions#getUnitdefs <em>Unitdefs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Definitions#getTypedefs <em>Typedefs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.Definitions#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getDefinitions()
 * @model
 * @generated
 */
public interface Definitions extends File
{
  /**
   * Returns the value of the '<em><b>Unitdefs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.UnitDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unitdefs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unitdefs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getDefinitions_Unitdefs()
   * @model containment="true"
   * @generated
   */
  EList<UnitDef> getUnitdefs();

  /**
   * Returns the value of the '<em><b>Typedefs</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.TypeDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typedefs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typedefs</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getDefinitions_Typedefs()
   * @model containment="true"
   * @generated
   */
  EList<TypeDef> getTypedefs();

  /**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.Constant}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getDefinitions_Constants()
   * @model containment="true"
   * @generated
   */
  EList<Constant> getConstants();

} // Definitions
