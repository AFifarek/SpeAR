/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Constant;
import com.rockwellcollins.spear.Definitions;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.TypeDef;
import com.rockwellcollins.spear.UnitDef;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.DefinitionsImpl#getUnitdefs <em>Unitdefs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.DefinitionsImpl#getTypedefs <em>Typedefs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.DefinitionsImpl#getConstants <em>Constants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefinitionsImpl extends FileImpl implements Definitions
{
  /**
   * The cached value of the '{@link #getUnitdefs() <em>Unitdefs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnitdefs()
   * @generated
   * @ordered
   */
  protected EList<UnitDef> unitdefs;

  /**
   * The cached value of the '{@link #getTypedefs() <em>Typedefs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypedefs()
   * @generated
   * @ordered
   */
  protected EList<TypeDef> typedefs;

  /**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
  protected EList<Constant> constants;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefinitionsImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SpearPackage.Literals.DEFINITIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnitDef> getUnitdefs()
  {
    if (unitdefs == null)
    {
      unitdefs = new EObjectContainmentEList<UnitDef>(UnitDef.class, this, SpearPackage.DEFINITIONS__UNITDEFS);
    }
    return unitdefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeDef> getTypedefs()
  {
    if (typedefs == null)
    {
      typedefs = new EObjectContainmentEList<TypeDef>(TypeDef.class, this, SpearPackage.DEFINITIONS__TYPEDEFS);
    }
    return typedefs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Constant> getConstants()
  {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<Constant>(Constant.class, this, SpearPackage.DEFINITIONS__CONSTANTS);
    }
    return constants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return ((InternalEList<?>)getUnitdefs()).basicRemove(otherEnd, msgs);
      case SpearPackage.DEFINITIONS__TYPEDEFS:
        return ((InternalEList<?>)getTypedefs()).basicRemove(otherEnd, msgs);
      case SpearPackage.DEFINITIONS__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return getUnitdefs();
      case SpearPackage.DEFINITIONS__TYPEDEFS:
        return getTypedefs();
      case SpearPackage.DEFINITIONS__CONSTANTS:
        return getConstants();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SpearPackage.DEFINITIONS__UNITDEFS:
        getUnitdefs().clear();
        getUnitdefs().addAll((Collection<? extends UnitDef>)newValue);
        return;
      case SpearPackage.DEFINITIONS__TYPEDEFS:
        getTypedefs().clear();
        getTypedefs().addAll((Collection<? extends TypeDef>)newValue);
        return;
      case SpearPackage.DEFINITIONS__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends Constant>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SpearPackage.DEFINITIONS__UNITDEFS:
        getUnitdefs().clear();
        return;
      case SpearPackage.DEFINITIONS__TYPEDEFS:
        getTypedefs().clear();
        return;
      case SpearPackage.DEFINITIONS__CONSTANTS:
        getConstants().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SpearPackage.DEFINITIONS__UNITDEFS:
        return unitdefs != null && !unitdefs.isEmpty();
      case SpearPackage.DEFINITIONS__TYPEDEFS:
        return typedefs != null && !typedefs.isEmpty();
      case SpearPackage.DEFINITIONS__CONSTANTS:
        return constants != null && !constants.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DefinitionsImpl
