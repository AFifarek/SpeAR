/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.LustreEquation;
import com.rockwellcollins.spear.Pattern;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.PatternImpl#getEquations <em>Equations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternImpl extends MinimalEObjectImpl.Container implements Pattern
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected EList<Variable> inputs;

  /**
   * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputs()
   * @generated
   * @ordered
   */
  protected EList<Variable> outputs;

  /**
   * The cached value of the '{@link #getLocals() <em>Locals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLocals()
   * @generated
   * @ordered
   */
  protected EList<Variable> locals;

  /**
   * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEquations()
   * @generated
   * @ordered
   */
  protected EList<LustreEquation> equations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternImpl()
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
    return SpearPackage.Literals.PATTERN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.PATTERN__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getInputs()
  {
    if (inputs == null)
    {
      inputs = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__INPUTS);
    }
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getOutputs()
  {
    if (outputs == null)
    {
      outputs = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__OUTPUTS);
    }
    return outputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Variable> getLocals()
  {
    if (locals == null)
    {
      locals = new EObjectContainmentEList<Variable>(Variable.class, this, SpearPackage.PATTERN__LOCALS);
    }
    return locals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LustreEquation> getEquations()
  {
    if (equations == null)
    {
      equations = new EObjectContainmentEList<LustreEquation>(LustreEquation.class, this, SpearPackage.PATTERN__EQUATIONS);
    }
    return equations;
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
      case SpearPackage.PATTERN__INPUTS:
        return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__LOCALS:
        return ((InternalEList<?>)getLocals()).basicRemove(otherEnd, msgs);
      case SpearPackage.PATTERN__EQUATIONS:
        return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.PATTERN__NAME:
        return getName();
      case SpearPackage.PATTERN__INPUTS:
        return getInputs();
      case SpearPackage.PATTERN__OUTPUTS:
        return getOutputs();
      case SpearPackage.PATTERN__LOCALS:
        return getLocals();
      case SpearPackage.PATTERN__EQUATIONS:
        return getEquations();
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
      case SpearPackage.PATTERN__NAME:
        setName((String)newValue);
        return;
      case SpearPackage.PATTERN__INPUTS:
        getInputs().clear();
        getInputs().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__LOCALS:
        getLocals().clear();
        getLocals().addAll((Collection<? extends Variable>)newValue);
        return;
      case SpearPackage.PATTERN__EQUATIONS:
        getEquations().clear();
        getEquations().addAll((Collection<? extends LustreEquation>)newValue);
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
      case SpearPackage.PATTERN__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SpearPackage.PATTERN__INPUTS:
        getInputs().clear();
        return;
      case SpearPackage.PATTERN__OUTPUTS:
        getOutputs().clear();
        return;
      case SpearPackage.PATTERN__LOCALS:
        getLocals().clear();
        return;
      case SpearPackage.PATTERN__EQUATIONS:
        getEquations().clear();
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
      case SpearPackage.PATTERN__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SpearPackage.PATTERN__INPUTS:
        return inputs != null && !inputs.isEmpty();
      case SpearPackage.PATTERN__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case SpearPackage.PATTERN__LOCALS:
        return locals != null && !locals.isEmpty();
      case SpearPackage.PATTERN__EQUATIONS:
        return equations != null && !equations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PatternImpl
