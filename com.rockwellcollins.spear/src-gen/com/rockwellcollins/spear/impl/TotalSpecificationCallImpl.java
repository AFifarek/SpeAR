/**
 */
package com.rockwellcollins.spear.impl;

import com.rockwellcollins.spear.Expr;
import com.rockwellcollins.spear.IdRef;
import com.rockwellcollins.spear.SpearPackage;
import com.rockwellcollins.spear.Specification;
import com.rockwellcollins.spear.TotalSpecificationCall;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Total Specification Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.spear.impl.TotalSpecificationCallImpl#getIds <em>Ids</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.TotalSpecificationCallImpl#getSpec <em>Spec</em>}</li>
 *   <li>{@link com.rockwellcollins.spear.impl.TotalSpecificationCallImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TotalSpecificationCallImpl extends ExprImpl implements TotalSpecificationCall
{
  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected EList<IdRef> ids;

  /**
   * The cached value of the '{@link #getSpec() <em>Spec</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpec()
   * @generated
   * @ordered
   */
  protected Specification spec;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expr> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TotalSpecificationCallImpl()
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
    return SpearPackage.Literals.TOTAL_SPECIFICATION_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IdRef> getIds()
  {
    if (ids == null)
    {
      ids = new EObjectResolvingEList<IdRef>(IdRef.class, this, SpearPackage.TOTAL_SPECIFICATION_CALL__IDS);
    }
    return ids;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Specification getSpec()
  {
    if (spec != null && spec.eIsProxy())
    {
      InternalEObject oldSpec = (InternalEObject)spec;
      spec = (Specification)eResolveProxy(oldSpec);
      if (spec != oldSpec)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC, oldSpec, spec));
      }
    }
    return spec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Specification basicGetSpec()
  {
    return spec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpec(Specification newSpec)
  {
    Specification oldSpec = spec;
    spec = newSpec;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC, oldSpec, spec));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expr>(Expr.class, this, SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS);
    }
    return args;
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
      case SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case SpearPackage.TOTAL_SPECIFICATION_CALL__IDS:
        return getIds();
      case SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC:
        if (resolve) return getSpec();
        return basicGetSpec();
      case SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS:
        return getArgs();
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
      case SpearPackage.TOTAL_SPECIFICATION_CALL__IDS:
        getIds().clear();
        getIds().addAll((Collection<? extends IdRef>)newValue);
        return;
      case SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC:
        setSpec((Specification)newValue);
        return;
      case SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expr>)newValue);
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
      case SpearPackage.TOTAL_SPECIFICATION_CALL__IDS:
        getIds().clear();
        return;
      case SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC:
        setSpec((Specification)null);
        return;
      case SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS:
        getArgs().clear();
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
      case SpearPackage.TOTAL_SPECIFICATION_CALL__IDS:
        return ids != null && !ids.isEmpty();
      case SpearPackage.TOTAL_SPECIFICATION_CALL__SPEC:
        return spec != null;
      case SpearPackage.TOTAL_SPECIFICATION_CALL__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TotalSpecificationCallImpl
