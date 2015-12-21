/**
 */
package com.rockwellcollins.spear;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.EnumType#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.spear.SpearPackage#getEnumType()
 * @model
 * @generated
 */
public interface EnumType extends TypeDef
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.spear.EnumValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see com.rockwellcollins.spear.SpearPackage#getEnumType_Values()
   * @model containment="true"
   * @generated
   */
  EList<EnumValue> getValues();

} // EnumType
