/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoLog;
import com.liferay.portal.workflow.kaleo.model.KaleoLogModel;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the KaleoLog service. Represents a row in the &quot;KaleoLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.workflow.kaleo.model.KaleoLogModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoLogImpl
 * @see com.liferay.portal.workflow.kaleo.model.KaleoLog
 * @see com.liferay.portal.workflow.kaleo.model.KaleoLogModel
 * @generated
 */
public class KaleoLogModelImpl extends BaseModelImpl<KaleoLog>
	implements KaleoLogModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo log model instance should use the {@link com.liferay.portal.workflow.kaleo.model.KaleoLog} interface instead.
	 */
	public static final String TABLE_NAME = "KaleoLog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "kaleoLogId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "kaleoClassName", Types.VARCHAR },
			{ "kaleoClassPK", Types.BIGINT },
			{ "kaleoDefinitionId", Types.BIGINT },
			{ "kaleoInstanceId", Types.BIGINT },
			{ "kaleoInstanceTokenId", Types.BIGINT },
			{ "kaleoTaskInstanceTokenId", Types.BIGINT },
			{ "kaleoNodeName", Types.VARCHAR },
			{ "terminalKaleoNode", Types.BOOLEAN },
			{ "kaleoActionId", Types.BIGINT },
			{ "kaleoActionName", Types.VARCHAR },
			{ "kaleoActionDescription", Types.VARCHAR },
			{ "previousKaleoNodeId", Types.BIGINT },
			{ "previousKaleoNodeName", Types.VARCHAR },
			{ "previousAssigneeClassName", Types.VARCHAR },
			{ "previousAssigneeClassPK", Types.BIGINT },
			{ "currentAssigneeClassName", Types.VARCHAR },
			{ "currentAssigneeClassPK", Types.BIGINT },
			{ "type_", Types.VARCHAR },
			{ "comment_", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "duration", Types.BIGINT },
			{ "workflowContext", Types.CLOB }
		};
	public static final String TABLE_SQL_CREATE = "create table KaleoLog (kaleoLogId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoClassName VARCHAR(200) null,kaleoClassPK LONG,kaleoDefinitionId LONG,kaleoInstanceId LONG,kaleoInstanceTokenId LONG,kaleoTaskInstanceTokenId LONG,kaleoNodeName VARCHAR(200) null,terminalKaleoNode BOOLEAN,kaleoActionId LONG,kaleoActionName VARCHAR(200) null,kaleoActionDescription STRING null,previousKaleoNodeId LONG,previousKaleoNodeName VARCHAR(200) null,previousAssigneeClassName VARCHAR(200) null,previousAssigneeClassPK LONG,currentAssigneeClassName VARCHAR(200) null,currentAssigneeClassPK LONG,type_ VARCHAR(50) null,comment_ STRING null,startDate DATE null,endDate DATE null,duration LONG,workflowContext TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table KaleoLog";
	public static final String ORDER_BY_JPQL = " ORDER BY kaleoLog.kaleoLogId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY KaleoLog.kaleoLogId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoLog"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoLog"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long KALEOCLASSNAME_COLUMN_BITMASK = 2L;
	public static long KALEOCLASSPK_COLUMN_BITMASK = 4L;
	public static long KALEODEFINITIONID_COLUMN_BITMASK = 8L;
	public static long KALEOINSTANCEID_COLUMN_BITMASK = 16L;
	public static long KALEOINSTANCETOKENID_COLUMN_BITMASK = 32L;
	public static long KALEOTASKINSTANCETOKENID_COLUMN_BITMASK = 64L;
	public static long TYPE_COLUMN_BITMASK = 128L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoLog"));

	public KaleoLogModelImpl() {
	}

	public long getPrimaryKey() {
		return _kaleoLogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setKaleoLogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_kaleoLogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return KaleoLog.class;
	}

	public String getModelClassName() {
		return KaleoLog.class.getName();
	}

	public long getKaleoLogId() {
		return _kaleoLogId;
	}

	public void setKaleoLogId(long kaleoLogId) {
		_columnBitmask = -1L;

		_kaleoLogId = kaleoLogId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getKaleoClassName() {
		if (_kaleoClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoClassName;
		}
	}

	public void setKaleoClassName(String kaleoClassName) {
		_columnBitmask |= KALEOCLASSNAME_COLUMN_BITMASK;

		if (_originalKaleoClassName == null) {
			_originalKaleoClassName = _kaleoClassName;
		}

		_kaleoClassName = kaleoClassName;
	}

	public String getOriginalKaleoClassName() {
		return GetterUtil.getString(_originalKaleoClassName);
	}

	public long getKaleoClassPK() {
		return _kaleoClassPK;
	}

	public void setKaleoClassPK(long kaleoClassPK) {
		_columnBitmask |= KALEOCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalKaleoClassPK) {
			_setOriginalKaleoClassPK = true;

			_originalKaleoClassPK = _kaleoClassPK;
		}

		_kaleoClassPK = kaleoClassPK;
	}

	public long getOriginalKaleoClassPK() {
		return _originalKaleoClassPK;
	}

	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}

	public long getKaleoInstanceId() {
		return _kaleoInstanceId;
	}

	public void setKaleoInstanceId(long kaleoInstanceId) {
		_columnBitmask |= KALEOINSTANCEID_COLUMN_BITMASK;

		if (!_setOriginalKaleoInstanceId) {
			_setOriginalKaleoInstanceId = true;

			_originalKaleoInstanceId = _kaleoInstanceId;
		}

		_kaleoInstanceId = kaleoInstanceId;
	}

	public long getOriginalKaleoInstanceId() {
		return _originalKaleoInstanceId;
	}

	public long getKaleoInstanceTokenId() {
		return _kaleoInstanceTokenId;
	}

	public void setKaleoInstanceTokenId(long kaleoInstanceTokenId) {
		_columnBitmask |= KALEOINSTANCETOKENID_COLUMN_BITMASK;

		if (!_setOriginalKaleoInstanceTokenId) {
			_setOriginalKaleoInstanceTokenId = true;

			_originalKaleoInstanceTokenId = _kaleoInstanceTokenId;
		}

		_kaleoInstanceTokenId = kaleoInstanceTokenId;
	}

	public long getOriginalKaleoInstanceTokenId() {
		return _originalKaleoInstanceTokenId;
	}

	public long getKaleoTaskInstanceTokenId() {
		return _kaleoTaskInstanceTokenId;
	}

	public void setKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId) {
		_columnBitmask |= KALEOTASKINSTANCETOKENID_COLUMN_BITMASK;

		if (!_setOriginalKaleoTaskInstanceTokenId) {
			_setOriginalKaleoTaskInstanceTokenId = true;

			_originalKaleoTaskInstanceTokenId = _kaleoTaskInstanceTokenId;
		}

		_kaleoTaskInstanceTokenId = kaleoTaskInstanceTokenId;
	}

	public long getOriginalKaleoTaskInstanceTokenId() {
		return _originalKaleoTaskInstanceTokenId;
	}

	public String getKaleoNodeName() {
		if (_kaleoNodeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoNodeName;
		}
	}

	public void setKaleoNodeName(String kaleoNodeName) {
		_kaleoNodeName = kaleoNodeName;
	}

	public boolean getTerminalKaleoNode() {
		return _terminalKaleoNode;
	}

	public boolean isTerminalKaleoNode() {
		return _terminalKaleoNode;
	}

	public void setTerminalKaleoNode(boolean terminalKaleoNode) {
		_terminalKaleoNode = terminalKaleoNode;
	}

	public long getKaleoActionId() {
		return _kaleoActionId;
	}

	public void setKaleoActionId(long kaleoActionId) {
		_kaleoActionId = kaleoActionId;
	}

	public String getKaleoActionName() {
		if (_kaleoActionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoActionName;
		}
	}

	public void setKaleoActionName(String kaleoActionName) {
		_kaleoActionName = kaleoActionName;
	}

	public String getKaleoActionDescription() {
		if (_kaleoActionDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _kaleoActionDescription;
		}
	}

	public void setKaleoActionDescription(String kaleoActionDescription) {
		_kaleoActionDescription = kaleoActionDescription;
	}

	public long getPreviousKaleoNodeId() {
		return _previousKaleoNodeId;
	}

	public void setPreviousKaleoNodeId(long previousKaleoNodeId) {
		_previousKaleoNodeId = previousKaleoNodeId;
	}

	public String getPreviousKaleoNodeName() {
		if (_previousKaleoNodeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _previousKaleoNodeName;
		}
	}

	public void setPreviousKaleoNodeName(String previousKaleoNodeName) {
		_previousKaleoNodeName = previousKaleoNodeName;
	}

	public String getPreviousAssigneeClassName() {
		if (_previousAssigneeClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _previousAssigneeClassName;
		}
	}

	public void setPreviousAssigneeClassName(String previousAssigneeClassName) {
		_previousAssigneeClassName = previousAssigneeClassName;
	}

	public long getPreviousAssigneeClassPK() {
		return _previousAssigneeClassPK;
	}

	public void setPreviousAssigneeClassPK(long previousAssigneeClassPK) {
		_previousAssigneeClassPK = previousAssigneeClassPK;
	}

	public String getCurrentAssigneeClassName() {
		if (_currentAssigneeClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _currentAssigneeClassName;
		}
	}

	public void setCurrentAssigneeClassName(String currentAssigneeClassName) {
		_currentAssigneeClassName = currentAssigneeClassName;
	}

	public long getCurrentAssigneeClassPK() {
		return _currentAssigneeClassPK;
	}

	public void setCurrentAssigneeClassPK(long currentAssigneeClassPK) {
		_currentAssigneeClassPK = currentAssigneeClassPK;
	}

	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	public String getComment() {
		if (_comment == null) {
			return StringPool.BLANK;
		}
		else {
			return _comment;
		}
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getDuration() {
		return _duration;
	}

	public void setDuration(long duration) {
		_duration = duration;
	}

	public String getWorkflowContext() {
		if (_workflowContext == null) {
			return StringPool.BLANK;
		}
		else {
			return _workflowContext;
		}
	}

	public void setWorkflowContext(String workflowContext) {
		_workflowContext = workflowContext;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public KaleoLog toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (KaleoLog)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					KaleoLog.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		KaleoLogImpl kaleoLogImpl = new KaleoLogImpl();

		kaleoLogImpl.setKaleoLogId(getKaleoLogId());
		kaleoLogImpl.setGroupId(getGroupId());
		kaleoLogImpl.setCompanyId(getCompanyId());
		kaleoLogImpl.setUserId(getUserId());
		kaleoLogImpl.setUserName(getUserName());
		kaleoLogImpl.setCreateDate(getCreateDate());
		kaleoLogImpl.setModifiedDate(getModifiedDate());
		kaleoLogImpl.setKaleoClassName(getKaleoClassName());
		kaleoLogImpl.setKaleoClassPK(getKaleoClassPK());
		kaleoLogImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoLogImpl.setKaleoInstanceId(getKaleoInstanceId());
		kaleoLogImpl.setKaleoInstanceTokenId(getKaleoInstanceTokenId());
		kaleoLogImpl.setKaleoTaskInstanceTokenId(getKaleoTaskInstanceTokenId());
		kaleoLogImpl.setKaleoNodeName(getKaleoNodeName());
		kaleoLogImpl.setTerminalKaleoNode(getTerminalKaleoNode());
		kaleoLogImpl.setKaleoActionId(getKaleoActionId());
		kaleoLogImpl.setKaleoActionName(getKaleoActionName());
		kaleoLogImpl.setKaleoActionDescription(getKaleoActionDescription());
		kaleoLogImpl.setPreviousKaleoNodeId(getPreviousKaleoNodeId());
		kaleoLogImpl.setPreviousKaleoNodeName(getPreviousKaleoNodeName());
		kaleoLogImpl.setPreviousAssigneeClassName(getPreviousAssigneeClassName());
		kaleoLogImpl.setPreviousAssigneeClassPK(getPreviousAssigneeClassPK());
		kaleoLogImpl.setCurrentAssigneeClassName(getCurrentAssigneeClassName());
		kaleoLogImpl.setCurrentAssigneeClassPK(getCurrentAssigneeClassPK());
		kaleoLogImpl.setType(getType());
		kaleoLogImpl.setComment(getComment());
		kaleoLogImpl.setStartDate(getStartDate());
		kaleoLogImpl.setEndDate(getEndDate());
		kaleoLogImpl.setDuration(getDuration());
		kaleoLogImpl.setWorkflowContext(getWorkflowContext());

		kaleoLogImpl.resetOriginalValues();

		return kaleoLogImpl;
	}

	public int compareTo(KaleoLog kaleoLog) {
		int value = 0;

		if (getKaleoLogId() < kaleoLog.getKaleoLogId()) {
			value = -1;
		}
		else if (getKaleoLogId() > kaleoLog.getKaleoLogId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		KaleoLog kaleoLog = null;

		try {
			kaleoLog = (KaleoLog)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = kaleoLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		KaleoLogModelImpl kaleoLogModelImpl = this;

		kaleoLogModelImpl._originalCompanyId = kaleoLogModelImpl._companyId;

		kaleoLogModelImpl._setOriginalCompanyId = false;

		kaleoLogModelImpl._originalKaleoClassName = kaleoLogModelImpl._kaleoClassName;

		kaleoLogModelImpl._originalKaleoClassPK = kaleoLogModelImpl._kaleoClassPK;

		kaleoLogModelImpl._setOriginalKaleoClassPK = false;

		kaleoLogModelImpl._originalKaleoDefinitionId = kaleoLogModelImpl._kaleoDefinitionId;

		kaleoLogModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoLogModelImpl._originalKaleoInstanceId = kaleoLogModelImpl._kaleoInstanceId;

		kaleoLogModelImpl._setOriginalKaleoInstanceId = false;

		kaleoLogModelImpl._originalKaleoInstanceTokenId = kaleoLogModelImpl._kaleoInstanceTokenId;

		kaleoLogModelImpl._setOriginalKaleoInstanceTokenId = false;

		kaleoLogModelImpl._originalKaleoTaskInstanceTokenId = kaleoLogModelImpl._kaleoTaskInstanceTokenId;

		kaleoLogModelImpl._setOriginalKaleoTaskInstanceTokenId = false;

		kaleoLogModelImpl._originalType = kaleoLogModelImpl._type;

		kaleoLogModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoLog> toCacheModel() {
		KaleoLogCacheModel kaleoLogCacheModel = new KaleoLogCacheModel();

		kaleoLogCacheModel.kaleoLogId = getKaleoLogId();

		kaleoLogCacheModel.groupId = getGroupId();

		kaleoLogCacheModel.companyId = getCompanyId();

		kaleoLogCacheModel.userId = getUserId();

		kaleoLogCacheModel.userName = getUserName();

		String userName = kaleoLogCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoLogCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoLogCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoLogCacheModel.kaleoClassName = getKaleoClassName();

		String kaleoClassName = kaleoLogCacheModel.kaleoClassName;

		if ((kaleoClassName != null) && (kaleoClassName.length() == 0)) {
			kaleoLogCacheModel.kaleoClassName = null;
		}

		kaleoLogCacheModel.kaleoClassPK = getKaleoClassPK();

		kaleoLogCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoLogCacheModel.kaleoInstanceId = getKaleoInstanceId();

		kaleoLogCacheModel.kaleoInstanceTokenId = getKaleoInstanceTokenId();

		kaleoLogCacheModel.kaleoTaskInstanceTokenId = getKaleoTaskInstanceTokenId();

		kaleoLogCacheModel.kaleoNodeName = getKaleoNodeName();

		String kaleoNodeName = kaleoLogCacheModel.kaleoNodeName;

		if ((kaleoNodeName != null) && (kaleoNodeName.length() == 0)) {
			kaleoLogCacheModel.kaleoNodeName = null;
		}

		kaleoLogCacheModel.terminalKaleoNode = getTerminalKaleoNode();

		kaleoLogCacheModel.kaleoActionId = getKaleoActionId();

		kaleoLogCacheModel.kaleoActionName = getKaleoActionName();

		String kaleoActionName = kaleoLogCacheModel.kaleoActionName;

		if ((kaleoActionName != null) && (kaleoActionName.length() == 0)) {
			kaleoLogCacheModel.kaleoActionName = null;
		}

		kaleoLogCacheModel.kaleoActionDescription = getKaleoActionDescription();

		String kaleoActionDescription = kaleoLogCacheModel.kaleoActionDescription;

		if ((kaleoActionDescription != null) &&
				(kaleoActionDescription.length() == 0)) {
			kaleoLogCacheModel.kaleoActionDescription = null;
		}

		kaleoLogCacheModel.previousKaleoNodeId = getPreviousKaleoNodeId();

		kaleoLogCacheModel.previousKaleoNodeName = getPreviousKaleoNodeName();

		String previousKaleoNodeName = kaleoLogCacheModel.previousKaleoNodeName;

		if ((previousKaleoNodeName != null) &&
				(previousKaleoNodeName.length() == 0)) {
			kaleoLogCacheModel.previousKaleoNodeName = null;
		}

		kaleoLogCacheModel.previousAssigneeClassName = getPreviousAssigneeClassName();

		String previousAssigneeClassName = kaleoLogCacheModel.previousAssigneeClassName;

		if ((previousAssigneeClassName != null) &&
				(previousAssigneeClassName.length() == 0)) {
			kaleoLogCacheModel.previousAssigneeClassName = null;
		}

		kaleoLogCacheModel.previousAssigneeClassPK = getPreviousAssigneeClassPK();

		kaleoLogCacheModel.currentAssigneeClassName = getCurrentAssigneeClassName();

		String currentAssigneeClassName = kaleoLogCacheModel.currentAssigneeClassName;

		if ((currentAssigneeClassName != null) &&
				(currentAssigneeClassName.length() == 0)) {
			kaleoLogCacheModel.currentAssigneeClassName = null;
		}

		kaleoLogCacheModel.currentAssigneeClassPK = getCurrentAssigneeClassPK();

		kaleoLogCacheModel.type = getType();

		String type = kaleoLogCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			kaleoLogCacheModel.type = null;
		}

		kaleoLogCacheModel.comment = getComment();

		String comment = kaleoLogCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			kaleoLogCacheModel.comment = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			kaleoLogCacheModel.startDate = startDate.getTime();
		}
		else {
			kaleoLogCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			kaleoLogCacheModel.endDate = endDate.getTime();
		}
		else {
			kaleoLogCacheModel.endDate = Long.MIN_VALUE;
		}

		kaleoLogCacheModel.duration = getDuration();

		kaleoLogCacheModel.workflowContext = getWorkflowContext();

		String workflowContext = kaleoLogCacheModel.workflowContext;

		if ((workflowContext != null) && (workflowContext.length() == 0)) {
			kaleoLogCacheModel.workflowContext = null;
		}

		return kaleoLogCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{kaleoLogId=");
		sb.append(getKaleoLogId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", kaleoClassName=");
		sb.append(getKaleoClassName());
		sb.append(", kaleoClassPK=");
		sb.append(getKaleoClassPK());
		sb.append(", kaleoDefinitionId=");
		sb.append(getKaleoDefinitionId());
		sb.append(", kaleoInstanceId=");
		sb.append(getKaleoInstanceId());
		sb.append(", kaleoInstanceTokenId=");
		sb.append(getKaleoInstanceTokenId());
		sb.append(", kaleoTaskInstanceTokenId=");
		sb.append(getKaleoTaskInstanceTokenId());
		sb.append(", kaleoNodeName=");
		sb.append(getKaleoNodeName());
		sb.append(", terminalKaleoNode=");
		sb.append(getTerminalKaleoNode());
		sb.append(", kaleoActionId=");
		sb.append(getKaleoActionId());
		sb.append(", kaleoActionName=");
		sb.append(getKaleoActionName());
		sb.append(", kaleoActionDescription=");
		sb.append(getKaleoActionDescription());
		sb.append(", previousKaleoNodeId=");
		sb.append(getPreviousKaleoNodeId());
		sb.append(", previousKaleoNodeName=");
		sb.append(getPreviousKaleoNodeName());
		sb.append(", previousAssigneeClassName=");
		sb.append(getPreviousAssigneeClassName());
		sb.append(", previousAssigneeClassPK=");
		sb.append(getPreviousAssigneeClassPK());
		sb.append(", currentAssigneeClassName=");
		sb.append(getCurrentAssigneeClassName());
		sb.append(", currentAssigneeClassPK=");
		sb.append(getCurrentAssigneeClassPK());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", workflowContext=");
		sb.append(getWorkflowContext());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.workflow.kaleo.model.KaleoLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kaleoLogId</column-name><column-value><![CDATA[");
		sb.append(getKaleoLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoClassName</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoClassPK</column-name><column-value><![CDATA[");
		sb.append(getKaleoClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoDefinitionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoDefinitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoInstanceId</column-name><column-value><![CDATA[");
		sb.append(getKaleoInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoInstanceTokenId</column-name><column-value><![CDATA[");
		sb.append(getKaleoInstanceTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoTaskInstanceTokenId</column-name><column-value><![CDATA[");
		sb.append(getKaleoTaskInstanceTokenId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoNodeName</column-name><column-value><![CDATA[");
		sb.append(getKaleoNodeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>terminalKaleoNode</column-name><column-value><![CDATA[");
		sb.append(getTerminalKaleoNode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoActionId</column-name><column-value><![CDATA[");
		sb.append(getKaleoActionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoActionName</column-name><column-value><![CDATA[");
		sb.append(getKaleoActionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kaleoActionDescription</column-name><column-value><![CDATA[");
		sb.append(getKaleoActionDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousKaleoNodeId</column-name><column-value><![CDATA[");
		sb.append(getPreviousKaleoNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousKaleoNodeName</column-name><column-value><![CDATA[");
		sb.append(getPreviousKaleoNodeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousAssigneeClassName</column-name><column-value><![CDATA[");
		sb.append(getPreviousAssigneeClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousAssigneeClassPK</column-name><column-value><![CDATA[");
		sb.append(getPreviousAssigneeClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentAssigneeClassName</column-name><column-value><![CDATA[");
		sb.append(getCurrentAssigneeClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentAssigneeClassPK</column-name><column-value><![CDATA[");
		sb.append(getCurrentAssigneeClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workflowContext</column-name><column-value><![CDATA[");
		sb.append(getWorkflowContext());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = KaleoLog.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			KaleoLog.class
		};
	private long _kaleoLogId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _kaleoClassName;
	private String _originalKaleoClassName;
	private long _kaleoClassPK;
	private long _originalKaleoClassPK;
	private boolean _setOriginalKaleoClassPK;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private long _kaleoInstanceId;
	private long _originalKaleoInstanceId;
	private boolean _setOriginalKaleoInstanceId;
	private long _kaleoInstanceTokenId;
	private long _originalKaleoInstanceTokenId;
	private boolean _setOriginalKaleoInstanceTokenId;
	private long _kaleoTaskInstanceTokenId;
	private long _originalKaleoTaskInstanceTokenId;
	private boolean _setOriginalKaleoTaskInstanceTokenId;
	private String _kaleoNodeName;
	private boolean _terminalKaleoNode;
	private long _kaleoActionId;
	private String _kaleoActionName;
	private String _kaleoActionDescription;
	private long _previousKaleoNodeId;
	private String _previousKaleoNodeName;
	private String _previousAssigneeClassName;
	private long _previousAssigneeClassPK;
	private String _currentAssigneeClassName;
	private long _currentAssigneeClassPK;
	private String _type;
	private String _originalType;
	private String _comment;
	private Date _startDate;
	private Date _endDate;
	private long _duration;
	private String _workflowContext;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private KaleoLog _escapedModelProxy;
}