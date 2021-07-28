/*******************************************************************************************************************************
Edge.java

Copyright © 2021, Power Integrations Corporation. All rights reserved.
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
Date   : Jul 18, 2021

Last modified by : ymohammad
Last modified on : Jul 18, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph;

/**
* Class Edge
*/
public class Edge implements Comparable<Edge> {
    private int sNode;
    private int nNode;
    private int weight;
    
    public Edge(int nNode, int weight) {
	super();
	this.nNode = nNode;
	this.weight = weight;
    }
    public Edge(int sNode, int nNode, int weight) {
	this(nNode, weight);
	this.sNode = sNode;
    }
    public int getnNode() {
        return this.nNode;
    }
    public void setnNode(int nNode) {
        this.nNode = nNode;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getsNode() {
        return this.sNode;
    }
    public void setsNode(int sNode) {
        this.sNode = sNode;
    }
    @Override
    public String toString() {
	return "Edge [nNode=" + this.nNode + ", weight=" + this.weight + "]";
    }

    @Override
    public int compareTo(Edge o) {
	return this.nNode-o.nNode;
    }
    
}
