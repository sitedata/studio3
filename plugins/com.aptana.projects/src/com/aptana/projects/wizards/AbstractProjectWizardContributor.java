/**
 * Aptana Studio
 * Copyright (c) 2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the GNU Public License (GPL) v3 (with exceptions).
 * Please see the license.html included with this distribution for details.
 * Any modifications to this file must keep this entire header intact.
 */
package com.aptana.projects.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.aptana.core.util.ArrayUtil;
import com.aptana.core.util.CollectionsUtil;
import com.aptana.core.util.StringUtil;

public abstract class AbstractProjectWizardContributor implements IProjectWizardContributor
{
	public static final String ATTRIBUTE_NATURE_ID = "natureId"; //$NON-NLS-1$
	private String natureId = StringUtil.EMPTY;

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException
	{
		natureId = config.getAttribute(ATTRIBUTE_NATURE_ID);
	}

	/*
	 * (non-Javadoc)
	 * @see com.aptana.projects.wizards.IProjectWizardContributor#hasNatureId(java.lang.String[])
	 */
	public boolean hasNatureId(String[] natureIds)
	{
		if (ArrayUtil.isEmpty(natureIds))
		{
			return false;
		}

		return CollectionsUtil.newList(natureIds).contains(natureId);
	}

	public IStatus performWizardFinish(IProject project)
	{
		return Status.OK_STATUS;
	}
}
