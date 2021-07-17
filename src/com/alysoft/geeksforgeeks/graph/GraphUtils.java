/*******************************************************************************************************************************
GraphUtils.java

Copyright � 2021, Power Integrations Corporation. All rights reserved.
The Programs (which include both the software and documentation) contain proprietary information of Power Integrations Corporation;
they are provided under a license agreement containing restrictions on use and disclosure and are also protected by
copyright, patent and other intellectual and industrial property law. Reverse engineering, disassembly or de-compilation of
the programs is prohibited.
Program Documentation is licensed for use solely to support the deployment of the Programs and not for any other
purpose.
The information contained in this document is subject to change without notice. If you find any problems in the
documentation, please report them to us in writing. Power Integrations Corporation does not warrant that this document is error free.
Except as may be expressly permitted in your license agreement for these Programs, no part of these Programs may be
reproduced or transmitted in any form or by any means, electronic or mechanical, for any purpose, without the express
written permission of Power Integrations Corporation.

Author : ymohammad
Date   : Jul 12, 2021

Last modified by : ymohammad
Last modified on : Jul 12, 2021

*******************************************************************************************************************************/

package com.alysoft.geeksforgeeks.graph;

import java.util.ArrayList;
import java.util.List;

/**
* Class GraphUtils
*/
public class GraphUtils {
    
    public static List<List<Integer>> createGraph(int nodesCount) {
	List<List<Integer>> graph = new ArrayList<List<Integer>>(nodesCount);
	for (int i = 0; i< nodesCount; i++) {
	    graph.add(new ArrayList<Integer>());
	}
	return graph;
    }
    public static void addEdge(List<List<Integer>> graph, int source, int node) {
	List<Integer> list0 = null;
	if (source < graph.size()) {
	    list0 = graph.get(source);
	    if (!list0.contains(node)) {
		list0.add(node);
		graph.set(source, list0);
	    }
	} else {
	    list0 = new ArrayList<Integer>();
	    list0.add(node);
	    graph.add(source, list0);
	}
	
	
	if (node < graph.size()) {
	    list0 = graph.get(node);
	    if (!list0.contains(source) ) {
		list0.add(source);
		graph.set(node, list0);
	    }
	} else {
	    list0 = new ArrayList<Integer>();
	    list0.add(source);
	    graph.add(node, list0);
	}
    }
}
